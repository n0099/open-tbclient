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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
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
    private static final Pattern hMM = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    private TbPageContext aRR;
    public com.baidu.tieba.write.b fZJ;
    private WriteUrlModel hMI;
    private j hMN;
    private com.baidu.tieba.write.model.a hMO;
    private com.baidu.tieba.write.transmit.model.a hMP;
    private com.baidu.tbadk.core.view.b hMQ;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == d.g.icon_invoke_link) {
                    i.this.bJk();
                    TiebaStatic.log(new ak("c12169"));
                }
                if (view.getId() == d.g.url_edit_back_view) {
                    i.this.bJj();
                }
            }
        }
    };
    private View.OnClickListener hMR = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == d.g.url_add) {
                TiebaStatic.log(new ak("c12163"));
                String bJx = i.this.hMN.bJx();
                if (i.hMM.matcher(bJx).matches()) {
                    i.this.bJj();
                    i.this.hMO.uv(bJx);
                    i.this.hMN.a(null, true);
                    return;
                }
                TiebaStatic.log(new ak("c12164"));
                i.this.hMN.bJy();
            }
        }
    };
    private TextWatcher hMS = new TextWatcher() { // from class: com.baidu.tieba.write.write.i.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            i.this.hMN.bJp();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (i.this.fZJ != null) {
                if (!i.this.fZJ.bFF()) {
                    i.this.nJ(false);
                }
                i.this.fZJ.nB(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hMT = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.i.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (i.this.hMP != null) {
                i.this.hMP.awP();
            }
        }
    };
    private a.InterfaceC0253a hDu = new a.InterfaceC0253a() { // from class: com.baidu.tieba.write.write.i.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0253a
        public void onError() {
            i.this.dZ(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0253a
        public void t(List<SimpleForum> list, int i) {
            i.this.dZ(list);
        }
    };
    private a.InterfaceC0017a cgm = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                i.this.mLat = String.valueOf(address.getLatitude());
                i.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d buw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.i.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            i.this.hMN.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                i.this.fZJ.aw(null);
                i.this.fZJ.nA(false);
                if (z) {
                    String errorString = postWriteCallBackData.getErrorString();
                    String preMsg = postWriteCallBackData.getPreMsg();
                    String colorMsg = postWriteCallBackData.getColorMsg();
                    if (i.this.d(writeData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(i.this.aRR.getPageActivity(), errorString, preMsg, colorMsg);
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    i.this.aRR.getPageActivity().setResult(-1, intent);
                    i.this.aRR.getPageActivity().finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    i.this.aRR.showToast(postWriteCallBackData.getErrorString());
                    i.this.fZJ.aw(postWriteCallBackData.getSensitiveWords());
                    i.this.fZJ.un(postWriteCallBackData.getErrorString());
                    if (!v.E(i.this.fZJ.bFC())) {
                        i.this.nJ(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    i.this.hMN.k(postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FY());
                    if (!com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(i.this.aRR.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(i.this.aRR.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FX())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(i.this.aRR.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public i(TbPageContext tbPageContext, j jVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hMQ = null;
        this.aRR = tbPageContext;
        this.hMN = jVar;
        this.hMO = aVar;
        this.hMI = writeUrlModel;
        this.hMN.U(this.mClickListener);
        this.hMN.V(this.hMR);
        this.hMN.e(this.hMS);
        bJk();
        this.hMQ = new com.baidu.tbadk.core.view.b(this.aRR);
        this.hMQ.d(this.hMT);
        bJi();
        this.hMI.b(this.buw);
        this.fZJ = new com.baidu.tieba.write.b();
        this.fZJ.xf(d.C0140d.cp_cont_i);
        this.fZJ.xg(d.C0140d.cp_cont_h_alpha85);
    }

    private void bJi() {
        this.hMP = new com.baidu.tieba.write.transmit.model.a(this.aRR.getUniqueId());
        this.hMP.a(this.hDu);
        if (this.hMI.getWriteData() != null) {
            this.hMP.setForumId(this.hMI.getWriteData().getForumId());
        }
    }

    protected void bJj() {
        this.hMN.bJw();
    }

    protected void bJk() {
        this.hMN.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ(List<SimpleForum> list) {
        WriteData writeData = this.hMI.getWriteData();
        if (writeData != null) {
            this.hMQ.bq(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.D(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1));
                    }
                }
            }
            TransmitForumActivityConfig transmitForumActivityConfig = new TransmitForumActivityConfig(this.aRR.getPageActivity(), 25013);
            CustomMessage customMessage = new CustomMessage(2002001, transmitForumActivityConfig);
            transmitForumActivityConfig.setRecommendForumList(arrayList);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    public void bxC() {
        if (ab.aR(this.aRR.getPageActivity())) {
            com.baidu.adp.lib.d.a.mG().a(true, this.cgm);
        }
    }

    public void destroy() {
        if (this.hMP != null) {
            this.hMP.destroy();
        }
        if (this.hMO != null) {
            this.hMO.destroy();
        }
        if (this.hMI != null) {
            this.hMI.cancelLoadData();
        }
    }

    public void ane() {
        this.hMP.setThreadContent(this.hMN.bJq());
        this.hMP.Wt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        if (this.hMN.bJs() != null && this.hMN.bJq() != null) {
            int selectionEnd = this.hMN.bJs().getSelectionEnd();
            SpannableStringBuilder b = this.fZJ.b(this.hMN.bJs().getText());
            if (b != null) {
                this.fZJ.nB(true);
                this.hMN.bJs().setText(b);
                if (z && this.fZJ.bFD() >= 0) {
                    this.hMN.bJs().requestFocus();
                    this.hMN.bJs().setSelection(this.fZJ.bFD());
                } else {
                    this.hMN.bJs().setSelection(selectionEnd);
                }
                this.fZJ.nA(this.fZJ.bFD() >= 0);
            }
        }
    }

    public boolean bJl() {
        if (this.fZJ.bFE()) {
            this.aRR.showToast(this.fZJ.bFG());
            nJ(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fZJ.onChangeSkinType();
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
                    this.aRR.getPageActivity().setResult(-1, intent2);
                }
                baseActivity.finish();
            } else if (i == 25013 && (writeData = this.hMI.getWriteData()) != null && this.hMO.bGS() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hMP.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bJm();
                } else if (ab.aR(this.aRR.getPageActivity())) {
                    com.baidu.adp.lib.d.a.mG().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.i.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                i.this.mLat = String.valueOf(address.getLatitude());
                                i.this.mLng = String.valueOf(address.getLongitude());
                            }
                            i.this.bJm();
                        }
                    });
                }
                this.hMN.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.aRR.showToast(postWriteCallBackData.getErrorString());
                        this.fZJ.aw(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.fZJ.bFC())) {
                            nJ(true);
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

    public void bJm() {
        this.hMI.e("", this.hMN.bJq(), this.hMO.bGS().linkUrl, this.hMO.bGS().linkUrlCode, this.mLat, this.mLng);
    }
}
