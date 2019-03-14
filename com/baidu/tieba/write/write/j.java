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
/* loaded from: classes3.dex */
public class j {
    private static final Pattern juU = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b fPi;
    private WriteUrlModel juQ;
    private k juV;
    private com.baidu.tieba.write.model.a juW;
    private com.baidu.tieba.write.transmit.model.a juX;
    private com.baidu.tbadk.core.view.b juY;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    j.this.cry();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    j.this.crx();
                }
            }
        }
    };
    private View.OnClickListener juZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new am("c12163"));
                String crL = j.this.juV.crL();
                if (j.juU.matcher(crL).matches()) {
                    j.this.crx();
                    j.this.juW.Et(crL);
                    j.this.juV.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.juV.crM();
            }
        }
    };
    private TextWatcher jva = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.juV.crD();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.fPi != null) {
                if (!j.this.fPi.cob()) {
                    j.this.re(false);
                }
                j.this.fPi.qV(false);
            }
        }
    };
    private DialogInterface.OnCancelListener jvb = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.juX != null) {
                j.this.juX.beY();
            }
        }
    };
    private a.InterfaceC0411a jlg = new a.InterfaceC0411a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0411a
        public void onError() {
            j.this.et(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0411a
        public void g(List<SimpleForum> list, int i) {
            j.this.et(list);
        }
    };
    private a.InterfaceC0015a djr = new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            j.this.juV.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.fPi.aE(null);
                j.this.fPi.qU(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (j.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(j.this.mContext.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    j.this.mContext.getPageActivity().setResult(-1, intent);
                    j.this.mContext.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    j.this.mContext.showToast(postWriteCallBackData.getErrorString());
                    j.this.fPi.aE(postWriteCallBackData.getSensitiveWords());
                    j.this.fPi.Ej(postWriteCallBackData.getErrorString());
                    if (!v.T(j.this.fPi.cnY())) {
                        j.this.re(true);
                    }
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.juV.l(postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.agE());
                    if (!com.baidu.tbadk.u.a.pT(xVar.agD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agD())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.juY = null;
        this.mContext = tbPageContext;
        this.juV = kVar;
        this.juW = aVar;
        this.juQ = writeUrlModel;
        this.juV.Z(this.mClickListener);
        this.juV.aa(this.juZ);
        this.juV.f(this.jva);
        cry();
        this.juY = new com.baidu.tbadk.core.view.b(this.mContext);
        this.juY.e(this.jvb);
        crw();
        this.juQ.b(this.cks);
        this.fPi = new com.baidu.tieba.write.b();
        this.fPi.AW(d.C0277d.cp_btn_a);
        this.fPi.AX(d.C0277d.cp_cont_h_alpha85);
    }

    private void crw() {
        this.juX = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.juX.a(this.jlg);
        if (this.juQ.getWriteData() != null) {
            this.juX.setForumId(this.juQ.getWriteData().getForumId());
        }
    }

    protected void crx() {
        this.juV.crK();
    }

    protected void cry() {
        this.juV.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(List<SimpleForum> list) {
        WriteData writeData = this.juQ.getWriteData();
        if (writeData != null) {
            this.juY.dJ(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.S(list) > 0) {
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

    public void cfb() {
        if (ab.cQ(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.iW().a(true, this.djr);
        }
    }

    public void destroy() {
        if (this.juX != null) {
            this.juX.destroy();
        }
        if (this.juW != null) {
            this.juW.destroy();
        }
        if (this.juQ != null) {
            this.juQ.cancelLoadData();
        }
    }

    public void aSi() {
        this.juX.setThreadContent(this.juV.crE());
        this.juX.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re(boolean z) {
        if (this.juV.crG() != null && this.juV.crE() != null) {
            int selectionEnd = this.juV.crG().getSelectionEnd();
            SpannableStringBuilder b = this.fPi.b(this.juV.crG().getText());
            if (b != null) {
                this.fPi.qV(true);
                this.juV.crG().setText(b);
                if (z && this.fPi.cnZ() >= 0) {
                    this.juV.crG().requestFocus();
                    this.juV.crG().setSelection(this.fPi.cnZ());
                } else {
                    this.juV.crG().setSelection(selectionEnd);
                }
                this.fPi.qU(this.fPi.cnZ() >= 0);
            }
        }
    }

    public boolean crz() {
        if (this.fPi.coa()) {
            this.mContext.showToast(this.fPi.coc());
            re(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fPi.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.juQ.getWriteData()) != null && this.juW.cpA() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.juX.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    crA();
                } else if (ab.cQ(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.iW().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.crA();
                        }
                    });
                }
                this.juV.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.fPi.aE(postWriteCallBackData.getSensitiveWords());
                        if (!v.T(this.fPi.cnY())) {
                            re(true);
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

    public void crA() {
        this.juQ.g("", this.juV.crE(), this.juW.cpA().linkUrl, this.juW.cpA().linkUrlCode, this.mLat, this.mLng);
    }
}
