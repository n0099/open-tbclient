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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.VoteInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.vote.c;
import com.baidu.tieba.write.write.cf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class WriteVoteActivity extends BaseActivity<WriteVoteActivity> implements View.OnClickListener, PopupWindow.OnDismissListener, RadioGroup.OnCheckedChangeListener, BdSwitchView.a, b, c.a, cf.a {
    private com.baidu.tbadk.img.b apC;
    private com.baidu.tieba.tbadkCore.writeModel.a aud;
    private int dUu;
    private n dWe;
    private String dWi;
    private BdToast dWk;
    private PostPrefixData mPrefixData;
    private final WriteData dJy = new WriteData();
    private final VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo();
    private final WriteImagesInfo dWf = new WriteImagesInfo();
    private int dWg = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.e.ds80);
    private final ImageOperation dWh = com.baidu.tbadk.img.effect.d.K(this.dWg, this.dWg);
    private DialogInterface.OnCancelListener cPd = null;
    private int dVN = 7;
    private boolean dWj = false;
    private int aUh = 0;
    private final CustomMessageListener dWl = new i(this, CmdConfigCustom.CMD_TEXT_CHANGED);
    private final a.d aut = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        this.dWe = new n(this);
        this.dWe.b(this.mPrefixData);
        this.aud = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.apC = new com.baidu.tbadk.img.b();
        initListener();
        if (!checkUpIsLogin()) {
            finish();
            return;
        }
        TiebaStatic.log("c10373");
        adjustResizeForSoftInput();
    }

    private void initListener() {
        this.aud.b(this.aut);
        registerListener(this.dWl);
        this.cPd = new k(this);
    }

    private void initData() {
        Intent intent = getIntent();
        this.dJy.setType(6);
        this.dJy.setForumId(intent.getStringExtra("forum_id"));
        this.dJy.setForumName(intent.getStringExtra("forum_name"));
        this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(n.j.write_no_prefix));
            this.dUu = 1;
        }
        AntiData antiData = (AntiData) intent.getSerializableExtra("anti");
        if (antiData != null && !TextUtils.isEmpty(antiData.getPollMessage())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), antiData.getPollMessage());
            finish();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.dWe != null) {
            if (i == n.g.radio_vote_pic) {
                this.dWe.fr(0);
                this.aUh = 0;
            } else if (i == n.g.radio_vote_text) {
                this.dWe.fr(1);
                this.aUh = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.ne(postWriteCallBackData.getErrorCode())) {
            AntiHelper.Q(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = getPageContext().getPageActivity().getString(n.j.error_write);
            }
            showToast(errorString);
        } else {
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.dWe != null && view == this.dWe.aLt()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.dWj = true;
            } else {
                this.dWj = false;
            }
            Nm();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.dWe != null) {
            Nm();
            if (view == this.dWe.aLv()) {
                if (this.dWe.aLu() != null) {
                    this.dWe.aLu().showDialog();
                }
            } else if (view == this.dWe.aLw()) {
                if (this.aUh == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.dWf.clear();
                    this.dWf.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dWf.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (this.aUh == 1) {
                    this.dWe.ow(1).aLj();
                }
            } else if (view == this.dWe.aLq()) {
                aLm();
            } else if (view == this.dWe.aLo()) {
                this.dWe.aO(view);
            } else if (view == this.dWe.aLp()) {
                this.dWe.aO(view);
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void R(int i, String str) {
        Nm();
        this.dVN = i;
        if (this.dWe != null) {
            this.dWe.nr(str);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void or(int i) {
        Nm();
        this.dWf.clear();
        this.dWf.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dWf.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestFrom(3);
        albumActivityConfig.setRequestCode(12002);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void os(int i) {
        Nm();
        if (this.dWe != null) {
            this.dWe.ox(i);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void Q(int i, String str) {
        Nm();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, "", "", "", true, "", true)));
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.dWe != null) {
            this.dWe.hT(false);
        }
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void ok(int i) {
        this.dUu = i;
        if (this.dWe != null && this.mPrefixData != null) {
            this.dWe.S(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dWe != null) {
            this.dWe.dO(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<g> aLx;
        if (this.dWe == null || (aLx = this.dWe.aLx()) == null) {
            return 10;
        }
        Iterator<g> it = aLx.iterator();
        int i = 0;
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.aLg()) {
                i++;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKF() {
        if (this.aud != null) {
            this.aud.cancelLoadData();
        }
    }

    private void aLm() {
        aKF();
        if (this.dWe != null && this.aud != null && this.dWe.aLr() != null && this.dWe.aLr() != null) {
            String trim = this.dWe.aLr().getText().toString().trim();
            String trim2 = this.dWe.aLs().getText().toString().trim();
            if (!bh(trim, trim2)) {
                aLn();
                return;
            }
            this.dJy.setVoteInfo(this.mVoteInfo);
            this.aud.c(this.dJy);
            this.dJy.setContent(trim2);
            this.dJy.setVcode(null);
            if (this.dUu != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.dWe.aLp() != null) {
                this.dJy.setTitle(String.valueOf(this.dWe.aLp().getText().toString()) + trim);
            } else {
                this.dJy.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.dJy.getTitle())) {
                this.dJy.setIsNoTitle(true);
            } else {
                this.dJy.setIsNoTitle(false);
            }
            if (!this.aud.aGD()) {
                ov(n.j.write_img_limit);
            } else if (this.aud.aGA()) {
                showLoadingDialog(getPageContext().getString(n.j.sending), this.cPd);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean bh(String str, String str2) {
        ArrayList<g> arrayList;
        List<g> aLy;
        int i;
        if (this.dWe == null) {
            return false;
        }
        if (this.aUh == 0) {
            aLy = this.dWe.aLx();
            if (!h(str2, aLy)) {
                return false;
            }
        } else if (this.aUh != 1) {
            arrayList = null;
            if (cf(arrayList)) {
                return false;
            }
            this.mWriteImagesInfo.clear();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.dVN);
            if (this.aUh == 0) {
                i = 2;
            } else {
                i = this.aUh == 1 ? 1 : -1;
            }
            if (i != -1) {
                this.mVoteInfo.setType(i);
                ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && (this.aUh != 1 || gVar.aLh())) {
                        ImageFileInfo aLk = gVar.aLk();
                        arrayList2.add(new VoteInfo.VoteOption(gVar.getId(), gVar.aLi(), aLk));
                        if (this.aUh == 0 && aLk != null) {
                            this.mWriteImagesInfo.addChooseFile(aLk);
                            this.mWriteImagesInfo.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.dWj ? 1 : 0);
                this.dJy.setWriteImagesInfo(this.mWriteImagesInfo);
                this.aud.hw(this.mWriteImagesInfo.size() > 0);
                return true;
            }
            return false;
        } else {
            aLy = this.dWe.aLy();
            if (!ce(aLy)) {
                return false;
            }
        }
        arrayList = aLy;
        if (cf(arrayList)) {
        }
    }

    private boolean h(String str, List<g> list) {
        if (cf(list)) {
            if (TextUtils.isEmpty(str)) {
                for (g gVar : list) {
                    if (gVar != null) {
                        if (!gVar.aLg()) {
                            gVar.aLj();
                            ov(n.j.vote_item_pic_no_ok);
                            return false;
                        } else if (!gVar.aLh()) {
                            gVar.ou(n.j.vote_hint);
                            ov(n.j.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (g gVar2 : list) {
                    if (gVar2 != null && !gVar2.aLg()) {
                        gVar2.aLj();
                        ov(n.j.vote_item_pic_no_ok);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean ce(List<g> list) {
        int i;
        if (cf(list)) {
            g gVar = null;
            int i2 = 0;
            for (g gVar2 : list) {
                if (gVar2 != null) {
                    if (!gVar2.aLh()) {
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
                gVar.ou(n.j.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean cf(List<g> list) {
        if (list == null || list.size() == 0) {
            ov(n.j.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            ov(n.j.vote_error_less_two);
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
                    Y(intent);
                } else {
                    X(intent);
                }
                this.dWf.clear();
            }
        } else if (i2 == 0) {
            Nm();
            switch (i) {
                case 12001:
                    BW();
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
                    this.dWi = String.valueOf(System.currentTimeMillis());
                    ar.b(getPageContext(), this.dWi);
                    return;
            }
        }
    }

    private void X(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.dWf.clear();
                this.dWf.parseJson(stringExtra);
                this.dWf.updateQuality();
            }
            if (this.dWf.size() >= 1) {
                Iterator<ImageFileInfo> it = this.dWf.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        h(next);
                    }
                }
            }
        }
    }

    private void Y(Intent intent) {
        h(Z(intent));
    }

    private void h(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null && this.apC != null) {
            imageFileInfo.addPageAction(this.dWh);
            com.baidu.adp.widget.a.a a = this.apC.a(imageFileInfo, false);
            if (a != null) {
                this.dWe.b(imageFileInfo, a);
            } else {
                this.apC.a(imageFileInfo, new l(this, imageFileInfo), false);
            }
        }
    }

    private ImageFileInfo Z(Intent intent) {
        this.dWi = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.dWi;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int cN = com.baidu.tbadk.core.util.c.cN(str);
            if (cN != 0) {
                Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                Bitmap i = com.baidu.tbadk.core.util.c.i(b, cN);
                if (b != i) {
                    b.recycle();
                }
                com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.dWi, i, 100);
                i.recycle();
            }
        } catch (Exception e) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }

    private void BW() {
        new m(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.apC != null) {
            this.apC.CS();
        }
        TiebaPrepareImageService.StopService();
        aKF();
        destroyWaitingDialog();
        super.onDestroy();
    }

    private void Nm() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void aLn() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), 150);
        }
    }

    private void nq(String str) {
        if (this.dWk == null) {
            this.dWk = BdToast.a(getApplicationContext(), 48, 0, 350);
        }
        this.dWk.b(str);
        this.dWk.to();
    }

    private void ov(int i) {
        nq(getApplicationContext().getResources().getString(i));
    }
}
