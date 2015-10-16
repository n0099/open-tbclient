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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.VoteInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.vote.c;
import com.baidu.tieba.write.write.cd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class WriteVoteActivity extends BaseActivity<WriteVoteActivity> implements View.OnClickListener, PopupWindow.OnDismissListener, RadioGroup.OnCheckedChangeListener, BdSwitchView.a, b, c.a, cd.a {
    private com.baidu.tbadk.img.b amg;
    private com.baidu.tieba.tbadkCore.writeModel.a arW;
    private int dmh;
    private n dnN;
    private String dnR;
    private BdToast dnT;
    private PostPrefixData mPrefixData;
    private final WriteData dbx = new WriteData();
    private final VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo();
    private final WriteImagesInfo dnO = new WriteImagesInfo();
    private int dnP = (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds80);
    private final ImageOperation dnQ = com.baidu.tbadk.img.effect.d.J(this.dnP, this.dnP);
    private DialogInterface.OnCancelListener cpX = null;
    private int dnw = 7;
    private boolean dnS = false;
    private int mCurrentTab = 0;
    private final CustomMessageListener dnU = new i(this, CmdConfigCustom.CMD_TEXT_CHANGED);
    private final a.d ask = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData();
        this.dnN = new n(this);
        this.dnN.b(this.mPrefixData);
        this.arW = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.amg = new com.baidu.tbadk.img.b();
        initListener();
        if (!checkUpIsLogin()) {
            finish();
        } else {
            TiebaStatic.log("c10373");
        }
    }

    private void initListener() {
        this.arW.b(this.ask);
        registerListener(this.dnU);
        this.cpX = new k(this);
    }

    private void initData() {
        Intent intent = getIntent();
        this.dbx.setType(6);
        this.dbx.setForumId(intent.getStringExtra("forum_id"));
        this.dbx.setForumName(intent.getStringExtra("forum_name"));
        this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(i.h.write_no_prefix));
            this.dmh = 1;
        }
        AntiData antiData = (AntiData) intent.getSerializableExtra("anti");
        if (antiData != null && !TextUtils.isEmpty(antiData.getPollMessage())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), antiData.getPollMessage());
            finish();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.dnN != null) {
            if (i == i.f.radio_vote_pic) {
                this.dnN.gt(0);
                this.mCurrentTab = 0;
            } else if (i == i.f.radio_vote_text) {
                this.dnN.gt(1);
                this.mCurrentTab = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.lc(postWriteCallBackData.getErrorCode())) {
            AntiHelper.P(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = getPageContext().getPageActivity().getString(i.h.error_write);
            }
            showToast(errorString);
        } else {
            com.baidu.tieba.tbadkCore.writeModel.e.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (this.dnN != null && view == this.dnN.aCN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                this.dnS = true;
            } else {
                this.dnS = false;
            }
            Lg();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.dnN != null) {
            Lg();
            if (view == this.dnN.aCP()) {
                if (this.dnN.aCO() != null) {
                    this.dnN.aCO().showDialog();
                }
            } else if (view == this.dnN.aCQ()) {
                if (this.mCurrentTab == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.dnO.clear();
                    this.dnO.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dnO.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (this.mCurrentTab == 1) {
                    this.dnN.me(1).aCD();
                }
            } else if (view == this.dnN.aCK()) {
                aCG();
            } else if (view == this.dnN.aCI()) {
                this.dnN.aA(view);
            } else if (view == this.dnN.aCJ()) {
                this.dnN.aA(view);
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void O(int i, String str) {
        Lg();
        this.dnw = i;
        if (this.dnN != null) {
            this.dnN.mt(str);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void lZ(int i) {
        Lg();
        this.dnO.clear();
        this.dnO.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.dnO.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestCode(12002);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void ma(int i) {
        Lg();
        if (this.dnN != null) {
            this.dnN.mf(i);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void N(int i, String str) {
        Lg();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, "", "", "", true, "", true)));
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.dnN != null) {
            this.dnN.gZ(false);
        }
    }

    @Override // com.baidu.tieba.write.write.cd.a
    public void lS(int i) {
        this.dmh = i;
        if (this.dnN != null && this.mPrefixData != null) {
            this.dnN.P(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dnN != null) {
            this.dnN.dF(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<g> aCR;
        if (this.dnN == null || (aCR = this.dnN.aCR()) == null) {
            return 10;
        }
        Iterator<g> it = aCR.iterator();
        int i = 0;
        while (it.hasNext()) {
            g next = it.next();
            if (next != null && next.aCA()) {
                i++;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCb() {
        if (this.arW != null) {
            this.arW.cancelLoadData();
        }
    }

    private void aCG() {
        aCb();
        if (this.dnN != null && this.arW != null && this.dnN.aCL() != null && this.dnN.aCL() != null) {
            String trim = this.dnN.aCL().getText().toString().trim();
            String trim2 = this.dnN.aCM().getText().toString().trim();
            if (!bj(trim, trim2)) {
                aCH();
                return;
            }
            this.dbx.setVoteInfo(this.mVoteInfo);
            this.arW.c(this.dbx);
            this.dbx.setContent(trim2);
            this.dbx.setVcode(null);
            if (this.dmh != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.dnN.aCJ() != null) {
                this.dbx.setTitle(String.valueOf(this.dnN.aCJ().getText().toString()) + trim);
            } else {
                this.dbx.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.dbx.getTitle())) {
                this.dbx.setIsNoTitle(true);
            } else {
                this.dbx.setIsNoTitle(false);
            }
            if (!this.arW.axS()) {
                md(i.h.write_img_limit);
            } else if (this.arW.axP()) {
                showLoadingDialog(getPageContext().getString(i.h.sending), this.cpX);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean bj(String str, String str2) {
        ArrayList<g> arrayList;
        List<g> aCS;
        int i;
        if (this.dnN == null) {
            return false;
        }
        if (this.mCurrentTab == 0) {
            aCS = this.dnN.aCR();
            if (!f(str2, aCS)) {
                return false;
            }
        } else if (this.mCurrentTab != 1) {
            arrayList = null;
            if (bK(arrayList)) {
                return false;
            }
            this.mWriteImagesInfo.clear();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.dnw);
            if (this.mCurrentTab == 0) {
                i = 2;
            } else {
                i = this.mCurrentTab == 1 ? 1 : -1;
            }
            if (i != -1) {
                this.mVoteInfo.setType(i);
                ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    g gVar = arrayList.get(i2);
                    if (gVar != null && (this.mCurrentTab != 1 || gVar.aCB())) {
                        ImageFileInfo aCE = gVar.aCE();
                        arrayList2.add(new VoteInfo.VoteOption(gVar.getId(), gVar.aCC(), aCE));
                        if (this.mCurrentTab == 0 && aCE != null) {
                            this.mWriteImagesInfo.addChooseFile(aCE);
                            this.mWriteImagesInfo.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.dnS ? 1 : 0);
                this.dbx.setWriteImagesInfo(this.mWriteImagesInfo);
                this.arW.gw(this.mWriteImagesInfo.size() > 0);
                return true;
            }
            return false;
        } else {
            aCS = this.dnN.aCS();
            if (!bJ(aCS)) {
                return false;
            }
        }
        arrayList = aCS;
        if (bK(arrayList)) {
        }
    }

    private boolean f(String str, List<g> list) {
        if (bK(list)) {
            if (TextUtils.isEmpty(str)) {
                for (g gVar : list) {
                    if (gVar != null) {
                        if (!gVar.aCA()) {
                            gVar.aCD();
                            md(i.h.vote_item_pic_no_ok);
                            return false;
                        } else if (!gVar.aCB()) {
                            gVar.mc(i.h.vote_hint);
                            md(i.h.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (g gVar2 : list) {
                    if (gVar2 != null && !gVar2.aCA()) {
                        gVar2.aCD();
                        md(i.h.vote_item_pic_no_ok);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean bJ(List<g> list) {
        int i;
        if (bK(list)) {
            g gVar = null;
            int i2 = 0;
            for (g gVar2 : list) {
                if (gVar2 != null) {
                    if (!gVar2.aCB()) {
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
                gVar.mc(i.h.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean bK(List<g> list) {
        if (list == null || list.size() == 0) {
            md(i.h.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            md(i.h.vote_error_less_two);
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
                    Z(intent);
                } else {
                    Y(intent);
                }
                this.dnO.clear();
            }
        } else if (i2 == 0) {
            Lg();
            switch (i) {
                case 12001:
                    Bt();
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
                    this.dnR = String.valueOf(System.currentTimeMillis());
                    am.a(getPageContext(), this.dnR);
                    return;
            }
        }
    }

    private void Y(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.dnO.clear();
                this.dnO.parseJson(stringExtra);
                this.dnO.updateQuality();
            }
            if (this.dnO.size() >= 1) {
                Iterator<ImageFileInfo> it = this.dnO.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        i(next);
                    }
                }
            }
        }
    }

    private void Z(Intent intent) {
        i(aa(intent));
    }

    private void i(ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null && this.amg != null) {
            imageFileInfo.addPageAction(this.dnQ);
            com.baidu.adp.widget.a.a a = this.amg.a(imageFileInfo, false);
            if (a != null) {
                this.dnN.b(imageFileInfo, a);
            } else {
                this.amg.a(imageFileInfo, new l(this, imageFileInfo), false);
            }
        }
    }

    private ImageFileInfo aa(Intent intent) {
        this.dnR = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.dnR;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int cC = com.baidu.tbadk.core.util.c.cC(str);
            if (cC != 0) {
                Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity())), com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity())));
                Bitmap i = com.baidu.tbadk.core.util.c.i(b, cC);
                if (b != i) {
                    b.recycle();
                }
                com.baidu.tbadk.core.util.n.a(TbConfig.LOCAL_CAMERA_DIR, this.dnR, i, 100);
                i.recycle();
            }
        } catch (Exception e) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }

    private void Bt() {
        new m(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.amg != null) {
            this.amg.Cm();
        }
        TiebaPrepareImageService.StopService();
        aCb();
        destroyWaitingDialog();
        super.onDestroy();
    }

    private void Lg() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void aCH() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
    }

    private void ms(String str) {
        if (this.dnT == null) {
            this.dnT = BdToast.a(getApplicationContext(), 48, 0, 350);
        }
        this.dnT.c(str);
        this.dnT.sZ();
    }

    private void md(int i) {
        ms(getApplicationContext().getResources().getString(i));
    }
}
