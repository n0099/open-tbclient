package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class i {
    private static final Pattern hVl = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aQq;
    public com.baidu.tieba.write.b fUG;
    private com.baidu.tbadk.core.view.b hLN;
    private WriteUrlModel hVg;
    private j hVm;
    private com.baidu.tieba.write.model.a hVn;
    private com.baidu.tieba.write.transmit.model.a hVo;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bOR();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bOQ();
                }
            }
        }
    };
    private View.OnClickListener hVp = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bPf = i.this.hVm.bPf();
                if (i.hVl.matcher(bPf).matches()) {
                    i.this.bOQ();
                    i.this.hVn.uM(bPf);
                    i.this.hVm.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hVm.bPg();
            }
        }
    };
    private TextWatcher hVq = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hVm.bOX();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fUG != null) {
                if (!i.this.fUG.bLp()) {
                    i.this.ow(false);
                }
                i.this.fUG.oo(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hLW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hVo != null) {
                i.this.hVo.auK();
            }
        }
    };
    private a.InterfaceC0171a hLV = new a.InterfaceC0171a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0171a
        public void onError() {
            i.this.ek(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0171a
        public void u(List<SimpleForum> list, int i) {
            i.this.ek(list);
        }
    };
    private a.InterfaceC0017a cbw = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d brP = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            i.this.hVm.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fUG.aB(null);
                i.this.fUG.on(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(i.this.aQq.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.aQq.getPageActivity().setResult(-1, intent);
                    i.this.aQq.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.aQq.showToast(postWriteCallBackData.getErrorString());
                    i.this.fUG.aB(postWriteCallBackData.getSensitiveWords());
                    i.this.fUG.uE(postWriteCallBackData.getErrorString());
                    if (!v.G(i.this.fUG.bLm())) {
                        i.this.ow(true);
                    }
                } else if ((sVar == null || writeData == null || sVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hVm.k(postWriteCallBackData);
                } else if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.FJ());
                    if (!com.baidu.tbadk.p.a.hf(sVar.FI())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(i.this.aQq.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(i.this.aQq.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.FI())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(i.this.aQq.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hLN = null;
        this.aQq = tbPageContext;
        this.hVm = jVar;
        this.hVn = aVar;
        this.hVg = writeUrlModel;
        this.hVm.W(this.mClickListener);
        this.hVm.X(this.hVp);
        this.hVm.e(this.hVq);
        bOR();
        this.hLN = new com.baidu.tbadk.core.view.b(this.aQq);
        this.hLN.c(this.hLW);
        bOP();
        this.hVg.b(this.brP);
        this.fUG = new com.baidu.tieba.write.b();
        this.fUG.yD(d.C0108d.cp_cont_i);
        this.fUG.yE(d.C0108d.cp_cont_h_alpha85);
    }

    private void bOP() {
        this.hVo = new com.baidu.tieba.write.transmit.model.a(this.aQq.getUniqueId());
        this.hVo.a(this.hLV);
        if (this.hVg.getWriteData() != null) {
            this.hVo.setForumId(this.hVg.getWriteData().getForumId());
        }
    }

    protected void bOQ() {
        this.hVm.bPe();
    }

    protected void bOR() {
        this.hVm.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ek(List<SimpleForum> list) {
        WriteData writeData = this.hVg.getWriteData();
        if (writeData != null) {
            this.hLN.bm(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.F(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aQq.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bCV() {
        if (ab.aS(this.aQq.getPageActivity())) {
            com.baidu.adp.lib.d.a.mF().a(true, this.cbw);
        }
    }

    public void destroy() {
        if (this.hVo != null) {
            this.hVo.destroy();
        }
        if (this.hVn != null) {
            this.hVn.destroy();
        }
        if (this.hVg != null) {
            this.hVg.cancelLoadData();
        }
    }

    public void bOS() {
        this.hVo.setThreadContent(this.hVm.bOY());
        this.hVo.VL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ow(boolean z) {
        if (this.hVm.bPa() != null && this.hVm.bOY() != null) {
            int selectionEnd = this.hVm.bPa().getSelectionEnd();
            SpannableStringBuilder b = this.fUG.b(this.hVm.bPa().getText());
            if (b != null) {
                this.fUG.oo(true);
                this.hVm.bPa().setText(b);
                if (z && this.fUG.bLn() >= 0) {
                    this.hVm.bPa().requestFocus();
                    this.hVm.bPa().setSelection(this.fUG.bLn());
                } else {
                    this.hVm.bPa().setSelection(selectionEnd);
                }
                this.fUG.on(this.fUG.bLn() >= 0);
            }
        }
    }

    public boolean bOT() {
        if (this.fUG.bLo()) {
            this.aQq.showToast(this.fUG.bLq());
            ow(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fUG.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    public void a(BaseActivity baseActivity, int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        WriteData writeData;
        if (i2 == -1) {
            if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                if (postWriteCallBackData2 != null) {
                    Intent intent2 = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent2.putExtras(bundle);
                    this.aQq.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hVg.getWriteData()) != null && this.hVn.bMC() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hVo.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bOU();
                } else if (ab.aS(this.aQq.getPageActivity())) {
                    com.baidu.adp.lib.d.a.mF().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bOU();
                        }
                    });
                }
                this.hVm.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.aQq.showToast(postWriteCallBackData.getErrorString());
                        this.fUG.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.G(this.fUG.bLm())) {
                            ow(true);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bOU() {
        this.hVg.e("", this.hVm.bOY(), this.hVn.bMC().linkUrl, this.hVn.bMC().linkUrlCode, this.mLat, this.mLng);
    }
}
