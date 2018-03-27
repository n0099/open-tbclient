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
    private com.baidu.tbadk.img.b bpm;
    private NewWriteModel btX;
    private AntiData buJ;
    private int gQq;
    private e hJo;
    private String hJs;
    private BdToast hJu;
    private PostPrefixData mPrefixData;
    private WriteData mData = new WriteData();
    private VoteInfo mVoteInfo = new VoteInfo();
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo();
    private final WriteImagesInfo hJp = new WriteImagesInfo();
    private int hJq = (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds80);
    private final ImageOperation hJr = com.baidu.tbadk.img.effect.d.aI(this.hJq, this.hJq);
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private int hIZ = 7;
    private boolean hJt = false;
    private int dRR = 0;
    private com.baidu.tbadk.core.view.b bCC = null;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (WriteVoteActivity.this.hJo != null && WriteVoteActivity.this.hJo.bHU() != null) {
                        WriteVoteActivity.this.hJo.bHU().sendAccessibilityEvent(8);
                    }
                    return true;
                default:
                    return false;
            }
        }
    };
    private Handler mHandler = new Handler(this.mHandlerCallback);
    private final CustomMessageListener hJv = new CustomMessageListener(2001357) { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001357 && WriteVoteActivity.this.hJo != null) {
                WriteVoteActivity.this.hJo.nQ(true);
            }
        }
    };
    private final NewWriteModel.d bum = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.5
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
        this.bCC = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hJo = new e(this);
        this.hJo.b(this.mPrefixData);
        this.btX = new NewWriteModel(this);
        this.bpm = new com.baidu.tbadk.img.b();
        initListener();
        if (!checkUpIsLogin()) {
            finish();
            return;
        }
        bkF();
        this.hJo.rZ(this.dRR);
        adjustResizeForSoftInput();
        TiebaStatic.log("c10373");
    }

    private void bkF() {
        if (this.hJo != null) {
            if (this.mData == null) {
                this.hJo.bHY();
                return;
            }
            this.hJo.bHP().setText(this.mData.getTitle());
            this.hJo.bHQ().setText(this.mData.getContent());
            this.hJo.bHU().setText(c.xD(this.hIZ));
            if (this.hJt) {
                this.hJo.bHR().rH();
            } else {
                this.hJo.bHR().rI();
            }
            if (this.mVoteInfo != null && !v.E(this.mVoteInfo.getOptions())) {
                c(this.mVoteInfo.getOptions(), this.mVoteInfo.getType());
                this.hJo.bHZ();
                return;
            }
            this.hJo.bHY();
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
                        this.hJo.uF(voteOption.text);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(final ImageFileInfo imageFileInfo, final String str) {
        if (imageFileInfo != null && this.bpm != null) {
            imageFileInfo.addPageAction(this.hJr);
            com.baidu.adp.widget.a.a a = this.bpm.a(imageFileInfo, false);
            if (a != null) {
                this.hJo.a(imageFileInfo, a, str);
            } else {
                this.bpm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.3
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z) {
                        if (aVar != null) {
                            WriteVoteActivity.this.hJo.a(imageFileInfo, aVar, str);
                        }
                    }
                }, false);
            }
        }
    }

    private void initListener() {
        this.btX.b(this.bum);
        registerListener(this.hJv);
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
            this.dRR = bundle.getInt("key_current_tab");
            this.mData = (WriteData) bundle.getSerializable("key_current_data");
            if (this.mData != null && this.mData.getVoteInfo() != null) {
                this.mVoteInfo = this.mData.getVoteInfo();
                this.hIZ = this.mVoteInfo.getEndtime();
                this.hJt = this.mVoteInfo.getIsMulti() == 1;
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
            this.gQq = 1;
        }
        this.buJ = (AntiData) intent.getSerializableExtra("anti");
        if (this.buJ != null && !TextUtils.isEmpty(this.buJ.getPollMessage())) {
            l.showToast(getPageContext().getPageActivity(), this.buJ.getPollMessage());
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
        bHJ();
        bundle.putInt("key_current_tab", this.dRR);
        bundle.putSerializable("key_current_data", this.mData);
        bundle.putSerializable("key_current_prefix_data", this.mPrefixData);
    }

    private void bHJ() {
        ArrayList<d> arrayList;
        String trim = this.hJo.bHP().getText().toString().trim();
        String trim2 = this.hJo.bHQ().getText().toString().trim();
        this.mData.setTitle(trim);
        this.mData.setContent(trim2);
        this.mWriteImagesInfo.clear();
        this.mWriteImagesInfo.setMaxImagesAllowed(10);
        this.mVoteInfo.setDescription(trim2);
        this.mVoteInfo.setEndtime(this.hIZ);
        if (this.dRR == 0) {
            arrayList = this.hJo.bHW();
        } else if (this.dRR != 1) {
            arrayList = null;
        } else {
            arrayList = this.hJo.bHX();
        }
        int i = -1;
        if (this.dRR == 0) {
            i = 2;
        } else if (this.dRR == 1) {
            i = 1;
        }
        this.mVoteInfo.setType(i);
        ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
        for (int i2 = 0; arrayList != null && i2 < arrayList.size(); i2++) {
            d dVar = arrayList.get(i2);
            if (dVar != null && (this.dRR != 1 || dVar.bHE())) {
                ImageFileInfo bHH = dVar.bHH();
                arrayList2.add(new VoteInfo.VoteOption(dVar.getId(), dVar.bHF(), bHH));
                if (this.dRR == 0 && bHH != null) {
                    this.mWriteImagesInfo.addChooseFile(bHH);
                    this.mWriteImagesInfo.updateQuality();
                }
            }
        }
        this.mVoteInfo.setOptions(arrayList2);
        this.mVoteInfo.setIsMulti(this.hJt ? 1 : 0);
        this.btX.mT(this.mWriteImagesInfo.size() > 0);
        this.mData.setWriteImagesInfo(this.mWriteImagesInfo);
        this.mData.setVoteInfo(this.mVoteInfo);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.hJo != null) {
            if (i == d.g.radio_vote_pic) {
                this.hJo.rZ(0);
                this.dRR = 0;
            } else if (i == d.g.radio_vote_text) {
                this.hJo.rZ(1);
                this.dRR = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (AntiHelper.vR(postWriteCallBackData.getErrorCode())) {
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
        if (this.hJo != null) {
            String string = getResources().getString(d.j.vote_multiple);
            if (view == this.hJo.bHR() && this.hJo.bHS() != null) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    this.hJt = true;
                    str = string + getResources().getString(d.j.now_state_on);
                } else {
                    this.hJt = false;
                    str = string + getResources().getString(d.j.now_state_off);
                }
                this.hJo.bHS().setContentDescription(str);
                avj();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.hJo != null) {
            avj();
            if (view == this.hJo.bHU()) {
                if (this.hJo.bHT() != null) {
                    this.hJo.bHT().showDialog();
                }
            } else if (view == this.hJo.bHV()) {
                if (this.dRR == 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    this.hJp.clear();
                    this.hJp.setMaxImagesAllowed(getMaxImagesAllowed());
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.hJp.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (this.dRR == 1) {
                    this.hJo.xG(1).bHG();
                }
            } else if (view == this.hJo.bHO()) {
                bHK();
            } else if (view == this.hJo.bHM()) {
                this.hJo.cW(view);
            } else if (view == this.hJo.bHN()) {
                this.hJo.cW(view);
            } else if (view == this.hJo.bHS() && this.hJo.bHR() != null) {
                if (this.hJo.bHR().nv()) {
                    this.hJo.bHR().rK();
                } else {
                    this.hJo.bHR().rJ();
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.vote.c.a
    public void an(int i, String str) {
        avj();
        this.hIZ = i;
        if (this.hJo != null) {
            this.hJo.uG(str);
        }
        if (!this.mHandler.hasMessages(0)) {
            this.mHandler.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    @Override // com.baidu.tieba.write.vote.b
    public void xA(int i) {
        avj();
        this.hJp.clear();
        this.hJp.setMaxImagesAllowed(getMaxImagesAllowed());
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(getPageContext().getPageActivity(), this.hJp.toJsonString(), String.valueOf(System.currentTimeMillis()), i);
        albumActivityConfig.setRequestFrom(3);
        albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
        sendMessage(new CustomMessage(2002001, albumActivityConfig));
    }

    @Override // com.baidu.tieba.write.vote.b
    public void xB(int i) {
        avj();
        if (this.hJo != null) {
            this.hJo.xH(i);
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
        if (this.hJo != null) {
            this.hJo.nR(false);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gQq = i;
        if (this.hJo != null && this.mPrefixData != null) {
            this.hJo.ao(i, this.mPrefixData.getPrefixs().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hJo != null) {
            this.hJo.hr(i);
        }
    }

    private int getMaxImagesAllowed() {
        ArrayList<d> bHW;
        if (this.hJo == null || (bHW = this.hJo.bHW()) == null) {
            return 10;
        }
        Iterator<d> it = bHW.iterator();
        int i = 0;
        while (it.hasNext()) {
            d next = it.next();
            if (next != null) {
                i = next.bHD() ? i + 1 : i;
            }
        }
        return 10 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsB() {
        if (this.btX != null) {
            this.btX.cancelLoadData();
        }
    }

    private void bHK() {
        bsB();
        if (this.hJo != null && this.btX != null && this.hJo.bHP() != null && this.hJo.bHP() != null) {
            String trim = this.hJo.bHP().getText().toString().trim();
            String trim2 = this.hJo.bHQ().getText().toString().trim();
            if (!co(trim, trim2)) {
                bHL();
                return;
            }
            this.mData.setVoteInfo(this.mVoteInfo);
            this.btX.setWriteData(this.mData);
            this.mData.setContent(trim2);
            this.mData.setVcode(null);
            if (this.gQq != 0 && this.mPrefixData != null && this.mPrefixData.getPrefixs() != null && this.mPrefixData.getPrefixs().size() > 0 && this.hJo.bHN() != null) {
                this.mData.setTitle(this.hJo.bHN().getText().toString() + trim);
            } else {
                this.mData.setTitle(trim);
            }
            if (TextUtils.isEmpty(this.mData.getTitle())) {
                this.mData.setIsNoTitle(true);
            } else {
                this.mData.setIsNoTitle(false);
            }
            if (!this.btX.byh()) {
                xF(d.j.write_img_limit);
            } else if (this.btX.startPostWrite()) {
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
        List<d> bHX;
        int i;
        if (this.hJo == null) {
            return false;
        }
        if (this.dRR == 0) {
            bHX = this.hJo.bHW();
            if (!q(str2, bHX)) {
                return false;
            }
        } else if (this.dRR != 1) {
            arrayList = null;
            if (dV(arrayList)) {
                return false;
            }
            this.mWriteImagesInfo.clear();
            this.mWriteImagesInfo.setMaxImagesAllowed(10);
            this.mVoteInfo.setDescription(str2);
            this.mVoteInfo.setEndtime(this.hIZ);
            if (this.dRR == 0) {
                i = 2;
            } else {
                i = this.dRR == 1 ? 1 : -1;
            }
            if (i != -1) {
                this.mVoteInfo.setType(i);
                ArrayList<VoteInfo.VoteOption> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    d dVar = arrayList.get(i2);
                    if (dVar != null && (this.dRR != 1 || dVar.bHE())) {
                        ImageFileInfo bHH = dVar.bHH();
                        arrayList2.add(new VoteInfo.VoteOption(dVar.getId(), dVar.bHF(), bHH));
                        if (this.dRR == 0 && bHH != null) {
                            this.mWriteImagesInfo.addChooseFile(bHH);
                            this.mWriteImagesInfo.updateQuality();
                        }
                    }
                }
                this.mVoteInfo.setOptions(arrayList2);
                this.mVoteInfo.setIsMulti(this.hJt ? 1 : 0);
                this.mData.setWriteImagesInfo(this.mWriteImagesInfo);
                this.btX.mT(this.mWriteImagesInfo.size() > 0);
                return true;
            }
            return false;
        } else {
            bHX = this.hJo.bHX();
            if (!dU(bHX)) {
                return false;
            }
        }
        arrayList = bHX;
        if (dV(arrayList)) {
        }
    }

    private boolean q(String str, List<d> list) {
        if (dV(list)) {
            if (TextUtils.isEmpty(str)) {
                for (d dVar : list) {
                    if (dVar != null) {
                        if (!dVar.bHD()) {
                            dVar.bHG();
                            xF(d.j.vote_item_pic_no_ok);
                            return false;
                        } else if (!dVar.bHE()) {
                            dVar.xE(d.j.vote_hint);
                            xF(d.j.vote_item_no_ok);
                            return false;
                        }
                    }
                }
            } else {
                for (d dVar2 : list) {
                    if (dVar2 != null && !dVar2.bHD()) {
                        dVar2.bHG();
                        xF(d.j.vote_item_pic_no_ok);
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
                    if (!dVar2.bHE()) {
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
                dVar.xE(d.j.vote_hint);
                return false;
            }
            return false;
        }
        return false;
    }

    private boolean dV(List<d> list) {
        if (list == null || list.size() == 0) {
            xF(d.j.vote_error_null);
            return false;
        } else if (list.size() < 2) {
            xF(d.j.vote_error_less_two);
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
                this.hJp.clear();
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
                    this.hJs = String.valueOf(System.currentTimeMillis());
                    uD(this.hJs);
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
                this.hJp.clear();
                this.hJp.parseJson(stringExtra);
                this.hJp.updateQuality();
            }
            if (this.hJp.size() >= 1) {
                Iterator<ImageFileInfo> it = this.hJp.getChosedFiles().iterator();
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
        if (imageFileInfo != null && this.bpm != null) {
            imageFileInfo.addPageAction(this.hJr);
            com.baidu.adp.widget.a.a a = this.bpm.a(imageFileInfo, false);
            if (a != null) {
                this.hJo.b(imageFileInfo, a);
            } else {
                this.bpm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.vote.WriteVoteActivity.6
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        if (aVar != null) {
                            WriteVoteActivity.this.hJo.b(imageFileInfo, aVar);
                        }
                    }
                }, false);
            }
        }
    }

    private ImageFileInfo ah(Intent intent) {
        this.hJs = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.hJs;
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
                k.a(TbConfig.LOCAL_CAMERA_DIR, this.hJs, rotateBitmapBydegree, 100);
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
                k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteVoteActivity.this.hJs));
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bpm != null) {
            this.bpm.MH();
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

    private void bHL() {
        if (getCurrentFocus() != null) {
            ShowSoftKeyPadDelay(getCurrentFocus(), BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        }
    }

    private void uE(String str) {
        if (this.hJu == null) {
            this.hJu = BdToast.b(getApplicationContext(), 48, 0, 350);
        }
        this.hJu.p(str);
        this.hJu.Bd();
    }

    private void xF(int i) {
        uE(getApplicationContext().getResources().getString(i));
    }

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0056a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aT(getApplicationContext())) {
                if (StringUtils.isNull(this.hJs)) {
                    ai.b(getPageContext());
                } else {
                    ai.a(getPageContext(), this.hJs);
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
        this.bCC.d(null);
        this.bCC.ga(d.j.sending);
        this.bCC.bq(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bCC.bq(false);
    }
}
