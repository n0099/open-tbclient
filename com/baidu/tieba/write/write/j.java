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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tbclient.SimpleForum;
/* loaded from: classes3.dex */
public class j {
    private static final Pattern icP = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b gkM;
    private WriteUrlModel icL;
    private k icQ;
    private com.baidu.tieba.write.model.a icR;
    private com.baidu.tieba.write.transmit.model.a icS;
    private com.baidu.tbadk.core.view.d icT;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == e.g.icon_invoke_link) {
                    j.this.bQU();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == e.g.url_edit_back_view) {
                    j.this.bQT();
                }
            }
        }
    };
    private View.OnClickListener icU = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == e.g.url_add) {
                TiebaStatic.log(new am("c12163"));
                String bRh = j.this.icQ.bRh();
                if (j.icP.matcher(bRh).matches()) {
                    j.this.bQT();
                    j.this.icR.xE(bRh);
                    j.this.icQ.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.icQ.bRi();
            }
        }
    };
    private TextWatcher icV = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.icQ.bQZ();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.gkM != null) {
                if (!j.this.gkM.bNO()) {
                    j.this.oD(false);
                }
                j.this.gkM.ou(false);
            }
        }
    };
    private DialogInterface.OnCancelListener icW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.icS != null) {
                j.this.icS.aDS();
            }
        }
    };
    private a.InterfaceC0338a hTG = new a.InterfaceC0338a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0338a
        public void onError() {
            j.this.en(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0338a
        public void h(List<SimpleForum> list, int i) {
            j.this.en(list);
        }
    };
    private a.InterfaceC0017a bTG = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d bai = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            j.this.icQ.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.gkM.aA(null);
                j.this.gkM.ot(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(j.this.mContext.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.mContext.getPageActivity().setResult(-1, intent);
                    j.this.mContext.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.mContext.showToast(postWriteCallBackData.getErrorString());
                    j.this.gkM.aA(postWriteCallBackData.getSensitiveWords());
                    j.this.gkM.xu(postWriteCallBackData.getErrorString());
                    if (!v.I(j.this.gkM.bNL())) {
                        j.this.oD(true);
                    }
                } else if ((wVar == null || writeData == null || wVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.icQ.l(postWriteCallBackData);
                } else if (wVar != null && writeData != null && wVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.GX());
                    if (!com.baidu.tbadk.r.a.iT(wVar.GW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GW())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.icT = null;
        this.mContext = tbPageContext;
        this.icQ = kVar;
        this.icR = aVar;
        this.icL = writeUrlModel;
        this.icQ.Z(this.mClickListener);
        this.icQ.aa(this.icU);
        this.icQ.e(this.icV);
        bQU();
        this.icT = new com.baidu.tbadk.core.view.d(this.mContext);
        this.icT.d(this.icW);
        bQS();
        this.icL.b(this.bai);
        this.gkM = new com.baidu.tieba.write.b();
        this.gkM.xi(e.d.cp_cont_i);
        this.gkM.xj(e.d.cp_cont_h_alpha85);
    }

    private void bQS() {
        this.icS = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.icS.a(this.hTG);
        if (this.icL.getWriteData() != null) {
            this.icS.setForumId(this.icL.getWriteData().getForumId());
        }
    }

    protected void bQT() {
        this.icQ.bRg();
    }

    protected void bQU() {
        this.icQ.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(List<SimpleForum> list) {
        WriteData writeData = this.icL.getWriteData();
        if (writeData != null) {
            this.icT.bA(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.H(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.mContext.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bEQ() {
        if (ab.bB(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, this.bTG);
        }
    }

    public void destroy() {
        if (this.icS != null) {
            this.icS.destroy();
        }
        if (this.icR != null) {
            this.icR.destroy();
        }
        if (this.icL != null) {
            this.icL.cancelLoadData();
        }
    }

    public void arS() {
        this.icS.setThreadContent(this.icQ.bRa());
        this.icS.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oD(boolean z) {
        if (this.icQ.bRc() != null && this.icQ.bRa() != null) {
            int selectionEnd = this.icQ.bRc().getSelectionEnd();
            SpannableStringBuilder b = this.gkM.b(this.icQ.bRc().getText());
            if (b != null) {
                this.gkM.ou(true);
                this.icQ.bRc().setText(b);
                if (z && this.gkM.bNM() >= 0) {
                    this.icQ.bRc().requestFocus();
                    this.icQ.bRc().setSelection(this.gkM.bNM());
                } else {
                    this.icQ.bRc().setSelection(selectionEnd);
                }
                this.gkM.ot(this.gkM.bNM() >= 0);
            }
        }
    }

    public boolean bQV() {
        if (this.gkM.bNN()) {
            this.mContext.showToast(this.gkM.bNP());
            oD(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.gkM.onChangeSkinType();
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
                    this.mContext.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.icL.getWriteData()) != null && this.icR.bOY() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.icS.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bQW();
                } else if (ab.bB(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bQW();
                        }
                    });
                }
                this.icQ.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.gkM.aA(postWriteCallBackData.getSensitiveWords());
                        if (!v.I(this.gkM.bNL())) {
                            oD(true);
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

    public void bQW() {
        this.icL.g("", this.icQ.bRa(), this.icR.bOY().linkUrl, this.icR.bOY().linkUrlCode, this.mLat, this.mLng);
    }
}
