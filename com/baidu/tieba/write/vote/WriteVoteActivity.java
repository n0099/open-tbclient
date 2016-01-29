package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.VoteInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.vote.c;
import com.baidu.tieba.write.write.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class WriteVoteActivity extends BaseActivity<WriteVoteActivity> implements View.OnClickListener, PopupWindow.OnDismissListener, RadioGroup.OnCheckedChangeListener, BdSwitchView.a, b, c.a, cc.a {
    private com.baidu.tbadk.img.b aqu;
    private com.baidu.tieba.tbadkCore.writeModel.a auV;
    private int eoZ;
    private n eqX;
    private String erb;
    private BdToast erd;
    private PostPrefixData mPrefixData;
    private final WriteData dZC = new WriteData();
    private final VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo cYj = new WriteImagesInfo();
    private final WriteImagesInfo eqY = new WriteImagesInfo();
    private int eqZ = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds80);
    private final ImageOperation era = com.baidu.tbadk.img.effect.d.G(this.eqZ, this.eqZ);
    private DialogInterface.OnCancelListener cYA = null;
    private int eqG = 7;
    private boolean erc = false;
    private int aWo = 0;
    private final CustomMessageListener ere = new i(this, CmdConfigCustom.CMD_TEXT_CHANGED);
    private final a.d avl = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        this.eqX = new n(this);
        this.eqX.b(this.mPrefixData);
        this.auV = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aqu = new com.baidu.tbadk.img.b();
        pm();
        if (!checkUpIsLogin()) {
            finish();
            return;
        }
        TiebaStatic.log("c10373");
        adjustResizeForSoftInput();
    }

    private void pm() {
        this.auV.b(this.avl);
        registerListener(this.ere);
        this.cYA = new k(this);
    }

    private void initData() {
        Intent intent = getIntent();
        this.dZC.setType(6);
        this.dZC.setForumId(intent.getStringExtra("forum_id"));
        this.dZC.setForumName(intent.getStringExtra("forum_name"));
        this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(t.j.write_no_prefix));
            this.eoZ = 1;
        }
        AntiData antiData = (AntiData) intent.getSerializableExtra("anti");
        if (antiData != null && !TextUtils.isEmpty(antiData.getPollMessage())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), antiData.getPollMessage());
            finish();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.eqX != null) {
            if (i == t.g.radio_vote_pic) {
                this.eqX.fQ(0);
                this.aWo = 0;
            } else if (i == t.g.radio_vote_text) {
                this.eqX.fQ(1);
                this.aWo = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.or(postWriteCallBackData.getErrorCode())) {
            AntiHelper.X(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = getPageContext().getPageActivity().getString(t.j.error_write);
            }
            showToast(errorString);
        } else {
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.eqX != null && view == this.eqX.aUo()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.erc = true;
            } else {
                this.erc = false;
            }
            Pj();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.eqX != null) {
            Pj();
            if (view == this.eqX.aUq()) {
                if (this.eqX.aUp() != null) {
                    this.eqX.aUp().Gp();
                }
            } else if (view == this.eqX.aUr()) {
                if (this.aWo == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.eqY.clear();
                    this.eqY.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.eqY.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (this.aWo == 1) {
                    this.eqX.pR(1).aUe();
                }
            } else if (view == this.eqX.aUl()) {
                aUh();
            } else if (view == this.eqX.aUj()) {
                this.eqX.bg(view);
            } else if (view == this.eqX.aUk()) {
                this.eqX.bg(view);
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void U(int i, String str) {
        Pj();
        this.eqG = i;
        if (this.eqX != null) {
            this.eqX.nI(str);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void pM(int i) {
        Pj();
        this.eqY.clear();
        this.eqY.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.eqY.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestFrom(3);
        albumActivityConfig.setRequestCode(12002);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void pN(int i) {
        Pj();
        if (this.eqX != null) {
            this.eqX.pS(i);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void T(int i, String str) {
        Pj();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, "", "", "", true, "", true)));
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.eqX != null) {
            this.eqX.iE(false);
        }
    }

    @Override // com.baidu.tieba.write.write.cc.a
    public void pF(int i) {
        this.eoZ = i;
        if (this.eqX != null && this.mPrefixData != null) {
            this.eqX.V(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eqX != null) {
            this.eqX.ej(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<g> aUs;
        if (this.eqX == null || (aUs = this.eqX.aUs()) == null) {
            return 10;
        }
        Iterator<g> it = aUs.iterator();
        int i = 0;
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.aUb()) {
                i++;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTp() {
        if (this.auV != null) {
            this.auV.cancelLoadData();
        }
    }

    private void aUh() {
        aTp();
        if (this.eqX != null && this.auV != null && this.eqX.aUm() != null && this.eqX.aUm() != null) {
            String trim = this.eqX.aUm().getText().toString().trim();
            String trim2 = this.eqX.aUn().getText().toString().trim();
            if (!bs(trim, trim2)) {
                aUi();
                return;
            }
            this.dZC.setVoteInfo(this.mVoteInfo);
            this.auV.c(this.dZC);
            this.dZC.setContent(trim2);
            this.dZC.setVcode(null);
            if (this.eoZ != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.eqX.aUk() != null) {
                this.dZC.setTitle(String.valueOf(this.eqX.aUk().getText().toString()) + trim);
            } else {
                this.dZC.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.dZC.getTitle())) {
                this.dZC.setIsNoTitle(true);
            } else {
                this.dZC.setIsNoTitle(false);
            }
            if (!this.auV.aNH()) {
                pQ(t.j.write_img_limit);
            } else if (this.auV.aNE()) {
                showLoadingDialog(getPageContext().getString(t.j.sending), this.cYA);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean bs(String str, String str2) {
        ArrayList<g> arrayList;
        List<g> aUt;
        int i;
        if (this.eqX == null) {
            return false;
        }
        if (this.aWo == 0) {
            aUt = this.eqX.aUs();
            if (!h(str2, aUt)) {
                return false;
            }
        } else if (this.aWo != 1) {
            arrayList = null;
            if (cs(arrayList)) {
                return false;
            }
            this.cYj.clear();
            this.cYj.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.eqG);
            if (this.aWo == 0) {
                i = 2;
            } else {
                i = this.aWo == 1 ? 1 : -1;
            }
            if (i != -1) {
                this.mVoteInfo.setType(i);
                ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && (this.aWo != 1 || gVar.aUc())) {
                        ImageFileInfo aUf = gVar.aUf();
                        arrayList2.add(new VoteInfo.VoteOption(gVar.getId(), gVar.aUd(), aUf));
                        if (this.aWo == 0 && aUf != null) {
                            this.cYj.addChooseFile(aUf);
                            this.cYj.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.erc ? 1 : 0);
                this.dZC.setWriteImagesInfo(this.cYj);
                this.auV.hX(this.cYj.size() > 0);
                return true;
            }
            return false;
        } else {
            aUt = this.eqX.aUt();
            if (!cr(aUt)) {
                return false;
            }
        }
        arrayList = aUt;
        if (cs(arrayList)) {
        }
    }

    private boolean h(String str, List<g> list) {
        if (cs(list)) {
            if (TextUtils.isEmpty(str)) {
                for (g gVar : list) {
                    if (gVar != null) {
                        if (!gVar.aUb()) {
                            gVar.aUe();
                            pQ(t.j.vote_item_pic_no_ok);
                            return false;
                        } else if (!gVar.aUc()) {
                            gVar.pP(t.j.vote_hint);
                            pQ(t.j.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (g gVar2 : list) {
                    if (gVar2 != null && !gVar2.aUb()) {
                        gVar2.aUe();
                        pQ(t.j.vote_item_pic_no_ok);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean cr(List<g> list) {
        int i;
        if (cs(list)) {
            g gVar = null;
            int i2 = 0;
            for (g gVar2 : list) {
                if (gVar2 != null) {
                    if (!gVar2.aUc()) {
                        if (gVar == null) {
                            i = i2;
                        } else {
                            gVar2 = gVar;
                            i = i2;
                        }
                    } else {
                        gVar2 = gVar;
                        i = i2 + 1;
                    }
                    if (i >= 2) {
                        return true;
                    }
                    i2 = i;
                    gVar = gVar2;
                }
            }
            if (i2 >= 2) {
                return true;
            }
            if (gVar != null) {
                gVar.pP(t.j.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean cs(List<g> list) {
        if (list == null || list.size() == 0) {
            pQ(t.j.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            pQ(t.j.vote_error_less_two);
            return false;
        } else {
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12006) {
                setResult(-1, intent);
                finish();
            } else if (i == 12002 && intent != null) {
                intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                    ab(intent);
                } else {
                    aa(intent);
                }
                this.eqY.clear();
            }
        } else if (i2 == 0) {
            Pj();
            switch (i) {
                case 12001:
                    Dm();
                    return;
                case 12002:
                case 12003:
                case 12004:
                case 12005:
                case 12006:
                case 12007:
                case 12008:
                case 12009:
                case 12011:
                case 12012:
                default:
                    return;
                case 12010:
                    this.erb = String.valueOf(System.currentTimeMillis());
                    aq.b(getPageContext(), this.erb);
                    return;
            }
        }
    }

    private void aa(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.eqY.clear();
                this.eqY.parseJson(stringExtra);
                this.eqY.updateQuality();
            }
            if (this.eqY.size() >= 1) {
                Iterator<ImageFileInfo> it = this.eqY.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        h(next);
                    }
                }
            }
        }
    }

    private void ab(Intent intent) {
        h(ac(intent));
    }

    private void h(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null && this.aqu != null) {
            imageFileInfo.addPageAction(this.era);
            com.baidu.adp.widget.a.a a = this.aqu.a(imageFileInfo, false);
            if (a != null) {
                this.eqX.b(imageFileInfo, a);
            } else {
                this.aqu.a(imageFileInfo, new l(this, imageFileInfo), false);
            }
        }
    }

    private ImageFileInfo ac(Intent intent) {
        this.erb = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.erb;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0) {
                Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                if (loadResizedBitmap != rotateBitmapBydegree) {
                    loadResizedBitmap.recycle();
                }
                com.baidu.tbadk.core.util.m.b(TbConfig.LOCAL_CAMERA_DIR, this.erb, rotateBitmapBydegree, 100);
                rotateBitmapBydegree.recycle();
            }
        } catch (Exception e) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }

    private void Dm() {
        new m(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aqu != null) {
            this.aqu.Ej();
        }
        TiebaPrepareImageService.StopService();
        aTp();
        destroyWaitingDialog();
        super.onDestroy();
    }

    private void Pj() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void aUi() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), 150);
        }
    }

    private void nH(String str) {
        if (this.erd == null) {
            this.erd = BdToast.a(getApplicationContext(), 48, 0, 350);
        }
        this.erd.b(str);
        this.erd.us();
    }

    private void pQ(int i) {
        nH(getApplicationContext().getResources().getString(i));
    }
}
