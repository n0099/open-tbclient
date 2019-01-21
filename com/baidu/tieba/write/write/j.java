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
import com.baidu.tbadk.coreExtra.data.x;
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
    private static final Pattern iea = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b glQ;
    private WriteUrlModel idW;
    private k ieb;
    private com.baidu.tieba.write.model.a iec;
    private com.baidu.tieba.write.transmit.model.a ied;
    private com.baidu.tbadk.core.view.d iee;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == e.g.icon_invoke_link) {
                    j.this.bRC();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == e.g.url_edit_back_view) {
                    j.this.bRB();
                }
            }
        }
    };
    private View.OnClickListener ief = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == e.g.url_add) {
                TiebaStatic.log(new am("c12163"));
                String bRP = j.this.ieb.bRP();
                if (j.iea.matcher(bRP).matches()) {
                    j.this.bRB();
                    j.this.iec.xU(bRP);
                    j.this.ieb.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.ieb.bRQ();
            }
        }
    };
    private TextWatcher ieg = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.ieb.bRH();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.glQ != null) {
                if (!j.this.glQ.bOw()) {
                    j.this.oE(false);
                }
                j.this.glQ.ov(false);
            }
        }
    };
    private DialogInterface.OnCancelListener ieh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.ied != null) {
                j.this.ied.aEp();
            }
        }
    };
    private a.InterfaceC0337a hUO = new a.InterfaceC0337a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0337a
        public void onError() {
            j.this.eo(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0337a
        public void h(List<SimpleForum> list, int i) {
            j.this.eo(list);
        }
    };
    private a.InterfaceC0017a bUs = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d baU = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            j.this.ieb.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.glQ.aA(null);
                j.this.glQ.ou(false);
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
                    j.this.glQ.aA(postWriteCallBackData.getSensitiveWords());
                    j.this.glQ.xK(postWriteCallBackData.getErrorString());
                    if (!v.I(j.this.glQ.bOt())) {
                        j.this.oE(true);
                    }
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.ieb.l(postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.Hl());
                    if (!com.baidu.tbadk.r.a.jj(xVar.Hk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.Hk())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.iee = null;
        this.mContext = tbPageContext;
        this.ieb = kVar;
        this.iec = aVar;
        this.idW = writeUrlModel;
        this.ieb.Z(this.mClickListener);
        this.ieb.aa(this.ief);
        this.ieb.e(this.ieg);
        bRC();
        this.iee = new com.baidu.tbadk.core.view.d(this.mContext);
        this.iee.d(this.ieh);
        bRA();
        this.idW.b(this.baU);
        this.glQ = new com.baidu.tieba.write.b();
        this.glQ.xk(e.d.cp_cont_i);
        this.glQ.xl(e.d.cp_cont_h_alpha85);
    }

    private void bRA() {
        this.ied = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.ied.a(this.hUO);
        if (this.idW.getWriteData() != null) {
            this.ied.setForumId(this.idW.getWriteData().getForumId());
        }
    }

    protected void bRB() {
        this.ieb.bRO();
    }

    protected void bRC() {
        this.ieb.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(List<SimpleForum> list) {
        WriteData writeData = this.idW.getWriteData();
        if (writeData != null) {
            this.iee.bB(false);
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

    public void bFz() {
        if (ab.bB(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, this.bUs);
        }
    }

    public void destroy() {
        if (this.ied != null) {
            this.ied.destroy();
        }
        if (this.iec != null) {
            this.iec.destroy();
        }
        if (this.idW != null) {
            this.idW.cancelLoadData();
        }
    }

    public void asq() {
        this.ied.setThreadContent(this.ieb.bRI());
        this.ied.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oE(boolean z) {
        if (this.ieb.bRK() != null && this.ieb.bRI() != null) {
            int selectionEnd = this.ieb.bRK().getSelectionEnd();
            SpannableStringBuilder b = this.glQ.b(this.ieb.bRK().getText());
            if (b != null) {
                this.glQ.ov(true);
                this.ieb.bRK().setText(b);
                if (z && this.glQ.bOu() >= 0) {
                    this.ieb.bRK().requestFocus();
                    this.ieb.bRK().setSelection(this.glQ.bOu());
                } else {
                    this.ieb.bRK().setSelection(selectionEnd);
                }
                this.glQ.ou(this.glQ.bOu() >= 0);
            }
        }
    }

    public boolean bRD() {
        if (this.glQ.bOv()) {
            this.mContext.showToast(this.glQ.bOx());
            oE(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.glQ.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.idW.getWriteData()) != null && this.iec.bPG() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.ied.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bRE();
                } else if (ab.bB(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bRE();
                        }
                    });
                }
                this.ieb.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.glQ.aA(postWriteCallBackData.getSensitiveWords());
                        if (!v.I(this.glQ.bOt())) {
                            oE(true);
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

    public void bRE() {
        this.idW.g("", this.ieb.bRI(), this.iec.bPG().linkUrl, this.iec.bPG().linkUrlCode, this.mLat, this.mLng);
    }
}
