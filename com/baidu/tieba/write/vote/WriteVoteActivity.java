package com.baidu.tieba.write.vote;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.d.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VoteInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.e;
import com.baidu.tieba.write.vote.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class WriteVoteActivity extends BaseActivity<WriteVoteActivity> implements View.OnClickListener, PopupWindow.OnDismissListener, RadioGroup.OnCheckedChangeListener, BdSwitchView.a, a.InterfaceC0056a, e.a, b, c.a {
    private com.baidu.tbadk.img.b bpw;
    private AntiData buT;
    private NewWriteModel bui;
    private int gQp;
    private e hJd;
    private String hJh;
    private BdToast hJj;
    private PostPrefixData mPrefixData;
    private WriteData mData = new WriteData();
    private VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo();
    private final WriteImagesInfo hJe = new WriteImagesInfo();
    private int hJf = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds80);
    private final ImageOperation hJg = com.baidu.tbadk.img.effect.d.aI(this.hJf, this.hJf);
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private int hIO = 7;
    private boolean hJi = false;
    private int dRY = 0;
    private com.baidu.tbadk.core.view.b bCM = null;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (WriteVoteActivity.this.hJd != null && WriteVoteActivity.this.hJd.bHQ() != null) {
                        WriteVoteActivity.this.hJd.bHQ().sendAccessibilityEvent(8);
                    }
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);
    private final CustomMessageListener hJk = new CustomMessageListener(2001357) { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001357 && WriteVoteActivity.this.hJd != null) {
                WriteVoteActivity.this.hJd.nL(true);
            }
        }
    };
    private final NewWriteModel.d buw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteVoteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (z) {
                    WriteVoteActivity.this.c(true, postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteVoteActivity.this.setResult(-1, intent);
                    WriteVoteActivity.this.finish();
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteVoteActivity.this.c(true, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FY());
                    if (com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        WriteVoteActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteVoteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FX())));
                    } else {
                        WriteVoteActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteVoteActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteVoteActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initData(bundle);
        this.bCM = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hJd = new e(this);
        this.hJd.b(this.mPrefixData);
        this.bui = new NewWriteModel(this);
        this.bpw = new com.baidu.tbadk.img.b();
        initListener();
        if (!checkUpIsLogin()) {
            finish();
            return;
        }
        bkF();
        this.hJd.rY(this.dRY);
        adjustResizeForSoftInput();
        TiebaStatic.log("c10373");
    }

    private void bkF() {
        if (this.hJd != null) {
            if (this.mData == null) {
                this.hJd.bHU();
                return;
            }
            this.hJd.bHL().setText(this.mData.getTitle());
            this.hJd.bHM().setText(this.mData.getContent());
            this.hJd.bHQ().setText(c.xC(this.hIO));
            if (this.hJi) {
                this.hJd.bHN().rH();
            } else {
                this.hJd.bHN().rI();
            }
            if (this.mVoteInfo != null && !v.E(this.mVoteInfo.getOptions())) {
                c(this.mVoteInfo.getOptions(), this.mVoteInfo.getType());
                this.hJd.bHV();
                return;
            }
            this.hJd.bHU();
        }
    }

    private void c(ArrayList<VoteInfo.VoteOption> arrayList, int i) {
        if (!v.E(arrayList)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < arrayList.size()) {
                    VoteInfo.VoteOption voteOption = arrayList.get(i3);
                    if (i == 2) {
                        a(voteOption.imageFileInfo, voteOption.text);
                    } else {
                        this.hJd.uF(voteOption.text);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(final ImageFileInfo imageFileInfo, final String str) {
        if (imageFileInfo != null && this.bpw != null) {
            imageFileInfo.addPageAction(this.hJg);
            com.baidu.adp.widget.a.a a = this.bpw.a(imageFileInfo, false);
            if (a != null) {
                this.hJd.a(imageFileInfo, a, str);
            } else {
                this.bpw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.3
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z) {
                        if (aVar != null) {
                            WriteVoteActivity.this.hJd.a(imageFileInfo, aVar, str);
                        }
                    }
                }, false);
            }
        }
    }

    private void initListener() {
        this.bui.b(this.buw);
        registerListener(this.hJk);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVoteActivity.this.destroyWaitingDialog();
                WriteVoteActivity.this.bsB();
            }
        };
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dRY = bundle.getInt("key_current_tab");
            this.mData = (WriteData) bundle.getSerializable("key_current_data");
            if (this.mData != null && this.mData.getVoteInfo() != null) {
                this.mVoteInfo = this.mData.getVoteInfo();
                this.hIO = this.mVoteInfo.getEndtime();
                this.hJi = this.mVoteInfo.getIsMulti() == 1;
            }
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("key_current_prefix_data");
            return;
        }
        Intent intent = getIntent();
        this.mData.setType(6);
        this.mData.setForumId(intent.getStringExtra("forum_id"));
        this.mData.setForumName(intent.getStringExtra("forum_name"));
        this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
            this.gQp = 1;
        }
        this.buT = (AntiData) intent.getSerializableExtra("anti");
        if (this.buT != null && !TextUtils.isEmpty(this.buT.getPollMessage())) {
            l.showToast(getPageContext().getPageActivity(), this.buT.getPollMessage());
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mHandler.removeMessages(0);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bHF();
        bundle.putInt("key_current_tab", this.dRY);
        bundle.putSerializable("key_current_data", this.mData);
        bundle.putSerializable("key_current_prefix_data", this.mPrefixData);
    }

    private void bHF() {
        ArrayList<d> arrayList;
        String trim = this.hJd.bHL().getText().toString().trim();
        String trim2 = this.hJd.bHM().getText().toString().trim();
        this.mData.setTitle(trim);
        this.mData.setContent(trim2);
        this.mWriteImagesInfo.clear();
        this.mWriteImagesInfo.setMaxImagesAllowed(10);
        this.mVoteInfo.setDescription(trim2);
        this.mVoteInfo.setEndtime(this.hIO);
        if (this.dRY == 0) {
            arrayList = this.hJd.bHS();
        } else if (this.dRY != 1) {
            arrayList = null;
        } else {
            arrayList = this.hJd.bHT();
        }
        int i = -1;
        if (this.dRY == 0) {
            i = 2;
        } else if (this.dRY == 1) {
            i = 1;
        }
        this.mVoteInfo.setType(i);
        ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
        for (int i2 = 0; arrayList != null && i2 < arrayList.size(); i2++) {
            d dVar = arrayList.get(i2);
            if (dVar != null && (this.dRY != 1 || dVar.bHA())) {
                ImageFileInfo bHD = dVar.bHD();
                arrayList2.add(new VoteInfo.VoteOption(dVar.getId(), dVar.bHB(), bHD));
                if (this.dRY == 0 && bHD != null) {
                    this.mWriteImagesInfo.addChooseFile(bHD);
                    this.mWriteImagesInfo.updateQuality();
                }
            }
        }
        this.mVoteInfo.setOptions(arrayList2);
        this.mVoteInfo.setIsMulti(this.hJi ? 1 : 0);
        this.bui.mO(this.mWriteImagesInfo.size() > 0);
        this.mData.setWriteImagesInfo(this.mWriteImagesInfo);
        this.mData.setVoteInfo(this.mVoteInfo);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.hJd != null) {
            if (i == d.g.radio_vote_pic) {
                this.hJd.rY(0);
                this.dRY = 0;
            } else if (i == d.g.radio_vote_text) {
                this.hJd.rY(1);
                this.dRY = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
            AntiHelper.ar(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
        } else if (postWriteCallBackData.getErrorCode() != 0) {
            String errorString = postWriteCallBackData.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = getPageContext().getPageActivity().getString(d.j.sand_fail);
            }
            showToast(errorString);
        } else {
            com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        String str;
        if (this.hJd != null) {
            String string = getResources().getString(d.j.vote_multiple);
            if (view == this.hJd.bHN() && this.hJd.bHO() != null) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.hJi = true;
                    str = string + getResources().getString(d.j.now_state_on);
                } else {
                    this.hJi = false;
                    str = string + getResources().getString(d.j.now_state_off);
                }
                this.hJd.bHO().setContentDescription(str);
                avj();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.hJd != null) {
            avj();
            if (view == this.hJd.bHQ()) {
                if (this.hJd.bHP() != null) {
                    this.hJd.bHP().showDialog();
                }
            } else if (view == this.hJd.bHR()) {
                if (this.dRY == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.hJe.clear();
                    this.hJe.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.hJe.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (this.dRY == 1) {
                    this.hJd.xF(1).bHC();
                }
            } else if (view == this.hJd.bHK()) {
                bHG();
            } else if (view == this.hJd.bHI()) {
                this.hJd.cW(view);
            } else if (view == this.hJd.bHJ()) {
                this.hJd.cW(view);
            } else if (view == this.hJd.bHO() && this.hJd.bHN() != null) {
                if (this.hJd.bHN().nv()) {
                    this.hJd.bHN().rK();
                } else {
                    this.hJd.bHN().rJ();
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void an(int i, String str) {
        avj();
        this.hIO = i;
        if (this.hJd != null) {
            this.hJd.uG(str);
        }
        if (!this.mHandler.hasMessages(0)) {
            this.mHandler.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void xz(int i) {
        avj();
        this.hJe.clear();
        this.hJe.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.hJe.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestFrom(3);
        albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
        sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void xA(int i) {
        avj();
        if (this.hJd != null) {
            this.hJd.xG(i);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void am(int i, String str) {
        avj();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        sendMessage(new CustomMessage(2010000, new ImageViewerConfig(getPageContext().getPageActivity()).createConfig(arrayList, 0, "", "", "", true, "", true)));
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.hJd != null) {
            this.hJd.nM(false);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vl(int i) {
        this.gQp = i;
        if (this.hJd != null && this.mPrefixData != null) {
            this.hJd.ao(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hJd != null) {
            this.hJd.hr(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<d> bHS;
        if (this.hJd == null || (bHS = this.hJd.bHS()) == null) {
            return 10;
        }
        Iterator<d> it = bHS.iterator();
        int i = 0;
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                i = next.bHz() ? i + 1 : i;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsB() {
        if (this.bui != null) {
            this.bui.cancelLoadData();
        }
    }

    private void bHG() {
        bsB();
        if (this.hJd != null && this.bui != null && this.hJd.bHL() != null && this.hJd.bHL() != null) {
            String trim = this.hJd.bHL().getText().toString().trim();
            String trim2 = this.hJd.bHM().getText().toString().trim();
            if (!co(trim, trim2)) {
                bHH();
                return;
            }
            this.mData.setVoteInfo(this.mVoteInfo);
            this.bui.setWriteData(this.mData);
            this.mData.setContent(trim2);
            this.mData.setVcode(null);
            if (this.gQp != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.hJd.bHJ() != null) {
                this.mData.setTitle(this.hJd.bHJ().getText().toString() + trim);
            } else {
                this.mData.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.mData.getTitle())) {
                this.mData.setIsNoTitle(true);
            } else {
                this.mData.setIsNoTitle(false);
            }
            if (!this.bui.byd()) {
                xE(d.j.write_img_limit);
            } else if (this.bui.startPostWrite()) {
                showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean co(String str, String str2) {
        ArrayList<d> arrayList;
        List<d> bHT;
        int i;
        if (this.hJd == null) {
            return false;
        }
        if (this.dRY == 0) {
            bHT = this.hJd.bHS();
            if (!q(str2, bHT)) {
                return false;
            }
        } else if (this.dRY != 1) {
            arrayList = null;
            if (dV(arrayList)) {
                return false;
            }
            this.mWriteImagesInfo.clear();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.hIO);
            if (this.dRY == 0) {
                i = 2;
            } else {
                i = this.dRY == 1 ? 1 : -1;
            }
            if (i != -1) {
                this.mVoteInfo.setType(i);
                ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    d dVar = arrayList.get(i2);
                    if (dVar != null && (this.dRY != 1 || dVar.bHA())) {
                        ImageFileInfo bHD = dVar.bHD();
                        arrayList2.add(new VoteInfo.VoteOption(dVar.getId(), dVar.bHB(), bHD));
                        if (this.dRY == 0 && bHD != null) {
                            this.mWriteImagesInfo.addChooseFile(bHD);
                            this.mWriteImagesInfo.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.hJi ? 1 : 0);
                this.mData.setWriteImagesInfo(this.mWriteImagesInfo);
                this.bui.mO(this.mWriteImagesInfo.size() > 0);
                return true;
            }
            return false;
        } else {
            bHT = this.hJd.bHT();
            if (!dU(bHT)) {
                return false;
            }
        }
        arrayList = bHT;
        if (dV(arrayList)) {
        }
    }

    private boolean q(String str, List<d> list) {
        if (dV(list)) {
            if (TextUtils.isEmpty(str)) {
                for (d dVar : list) {
                    if (dVar != null) {
                        if (!dVar.bHz()) {
                            dVar.bHC();
                            xE(d.j.vote_item_pic_no_ok);
                            return false;
                        } else if (!dVar.bHA()) {
                            dVar.xD(d.j.vote_hint);
                            xE(d.j.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (d dVar2 : list) {
                    if (dVar2 != null && !dVar2.bHz()) {
                        dVar2.bHC();
                        xE(d.j.vote_item_pic_no_ok);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean dU(List<d> list) {
        int i;
        if (dV(list)) {
            d dVar = null;
            int i2 = 0;
            for (d dVar2 : list) {
                if (dVar2 != null) {
                    if (!dVar2.bHA()) {
                        if (dVar == null) {
                            i = i2;
                        } else {
                            dVar2 = dVar;
                            i = i2;
                        }
                    } else {
                        dVar2 = dVar;
                        i = i2 + 1;
                    }
                    if (i >= 2) {
                        return true;
                    }
                    i2 = i;
                    dVar = dVar2;
                }
            }
            if (i2 >= 2) {
                return true;
            }
            if (dVar != null) {
                dVar.xD(d.j.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean dV(List<d> list) {
        if (list == null || list.size() == 0) {
            xE(d.j.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            xE(d.j.vote_error_less_two);
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12006) {
                setResult(-1, intent);
                finish();
            } else if (i == 12002 && intent != null) {
                intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                    ag(intent);
                } else {
                    af(intent);
                }
                this.hJe.clear();
            }
        } else if (i2 == 0) {
            avj();
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    LJ();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY /* 12005 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME /* 12007 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA /* 12008 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE /* 12011 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.hJh = String.valueOf(System.currentTimeMillis());
                    uD(this.hJh);
                    return;
            }
        }
    }

    private void uD(String str) {
        if (!ab.e(getPageContext().getPageActivity(), 1)) {
            ai.a(getPageContext(), str);
        }
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.hJe.clear();
                this.hJe.parseJson(stringExtra);
                this.hJe.updateQuality();
            }
            if (this.hJe.size() >= 1) {
                Iterator<ImageFileInfo> it = this.hJe.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        h(next);
                    }
                }
            }
        }
    }

    private void ag(Intent intent) {
        h(ah(intent));
    }

    private void h(final ImageFileInfo imageFileInfo) {
        if (imageFileInfo != null && this.bpw != null) {
            imageFileInfo.addPageAction(this.hJg);
            com.baidu.adp.widget.a.a a = this.bpw.a(imageFileInfo, false);
            if (a != null) {
                this.hJd.b(imageFileInfo, a);
            } else {
                this.bpw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.6
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        if (aVar != null) {
                            WriteVoteActivity.this.hJd.b(imageFileInfo, aVar);
                        }
                    }
                }, false);
            }
        }
    }

    private ImageFileInfo ah(Intent intent) {
        this.hJh = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.hJh;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int readPictureDegree = BitmapHelper.readPictureDegree(str);
            if (readPictureDegree != 0) {
                Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ao(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aq(getPageContext().getPageActivity())));
                Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                if (loadResizedBitmap != rotateBitmapBydegree) {
                    loadResizedBitmap.recycle();
                }
                k.a(TbConfig.LOCAL_CAMERA_DIR, this.hJh, rotateBitmapBydegree, 100);
                rotateBitmapBydegree.recycle();
            }
        } catch (Exception e) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }

    private void LJ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteVoteActivity.this.hJh));
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bpw != null) {
            this.bpw.MH();
        }
        TiebaPrepareImageService.StopService();
        bsB();
        destroyWaitingDialog();
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    private void avj() {
        if (getCurrentFocus() != null) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void bHH() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    private void uE(String str) {
        if (this.hJj == null) {
            this.hJj = BdToast.b(getApplicationContext(), 48, 0, 350);
        }
        this.hJj.p(str);
        this.hJj.Bc();
    }

    private void xE(int i) {
        uE(getApplicationContext().getResources().getString(i));
    }

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0056a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aT(getApplicationContext())) {
                if (StringUtils.isNull(this.hJh)) {
                    ai.b(getPageContext());
                } else {
                    ai.a(getPageContext(), this.hJh);
                }
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bCM.d(null);
        this.bCM.ga(d.j.sending);
        this.bCM.bq(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bCM.bq(false);
    }
}
