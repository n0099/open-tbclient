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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
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
    private static final Pattern hQJ = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b fZG;
    private WriteUrlModel hQF;
    private k hQK;
    private com.baidu.tieba.write.model.a hQL;
    private com.baidu.tieba.write.transmit.model.a hQM;
    private com.baidu.tbadk.core.view.d hQN;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == e.g.icon_invoke_link) {
                    j.this.bOz();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == e.g.url_edit_back_view) {
                    j.this.bOy();
                }
            }
        }
    };
    private View.OnClickListener hQO = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == e.g.url_add) {
                TiebaStatic.log(new am("c12163"));
                String bOM = j.this.hQK.bOM();
                if (j.hQJ.matcher(bOM).matches()) {
                    j.this.bOy();
                    j.this.hQL.wT(bOM);
                    j.this.hQK.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.hQK.bON();
            }
        }
    };
    private TextWatcher hQP = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hQK.bOE();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.fZG != null) {
                if (!j.this.fZG.bLt()) {
                    j.this.ok(false);
                }
                j.this.fZG.ob(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hQQ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hQM != null) {
                j.this.hQM.aBV();
            }
        }
    };
    private a.InterfaceC0296a hHz = new a.InterfaceC0296a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0296a
        public void onError() {
            j.this.ek(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0296a
        public void h(List<SimpleForum> list, int i) {
            j.this.ek(list);
        }
    };
    private a.InterfaceC0017a bPb = new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aVS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            j.this.hQK.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.fZG.aA(null);
                j.this.fZG.oa(false);
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
                    j.this.fZG.aA(postWriteCallBackData.getSensitiveWords());
                    j.this.fZG.wJ(postWriteCallBackData.getErrorString());
                    if (!com.baidu.tbadk.core.util.v.J(j.this.fZG.bLq())) {
                        j.this.ok(true);
                    }
                } else if ((vVar == null || writeData == null || vVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hQK.l(postWriteCallBackData);
                } else if (vVar != null && writeData != null && vVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(vVar.getVcode_md5());
                    writeData.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData.setVcodeExtra(vVar.FG());
                    if (!com.baidu.tbadk.q.a.iy(vVar.FF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.FF())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hQN = null;
        this.mContext = tbPageContext;
        this.hQK = kVar;
        this.hQL = aVar;
        this.hQF = writeUrlModel;
        this.hQK.X(this.mClickListener);
        this.hQK.Y(this.hQO);
        this.hQK.e(this.hQP);
        bOz();
        this.hQN = new com.baidu.tbadk.core.view.d(this.mContext);
        this.hQN.d(this.hQQ);
        bOx();
        this.hQF.b(this.aVS);
        this.fZG = new com.baidu.tieba.write.b();
        this.fZG.wf(e.d.cp_cont_i);
        this.fZG.wg(e.d.cp_cont_h_alpha85);
    }

    private void bOx() {
        this.hQM = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hQM.a(this.hHz);
        if (this.hQF.getWriteData() != null) {
            this.hQM.setForumId(this.hQF.getWriteData().getForumId());
        }
    }

    protected void bOy() {
        this.hQK.bOL();
    }

    protected void bOz() {
        this.hQK.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ek(List<SimpleForum> list) {
        WriteData writeData = this.hQF.getWriteData();
        if (writeData != null) {
            this.hQN.bj(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (com.baidu.tbadk.core.util.v.I(list) > 0) {
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

    public void bCJ() {
        if (ab.bA(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.iX().a(true, this.bPb);
        }
    }

    public void destroy() {
        if (this.hQM != null) {
            this.hQM.destroy();
        }
        if (this.hQL != null) {
            this.hQL.destroy();
        }
        if (this.hQF != null) {
            this.hQF.cancelLoadData();
        }
    }

    public void apP() {
        this.hQM.setThreadContent(this.hQK.bOF());
        this.hQM.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(boolean z) {
        if (this.hQK.bOH() != null && this.hQK.bOF() != null) {
            int selectionEnd = this.hQK.bOH().getSelectionEnd();
            SpannableStringBuilder b = this.fZG.b(this.hQK.bOH().getText());
            if (b != null) {
                this.fZG.ob(true);
                this.hQK.bOH().setText(b);
                if (z && this.fZG.bLr() >= 0) {
                    this.hQK.bOH().requestFocus();
                    this.hQK.bOH().setSelection(this.fZG.bLr());
                } else {
                    this.hQK.bOH().setSelection(selectionEnd);
                }
                this.fZG.oa(this.fZG.bLr() >= 0);
            }
        }
    }

    public boolean bOA() {
        if (this.fZG.bLs()) {
            this.mContext.showToast(this.fZG.bLu());
            ok(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fZG.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.hQF.getWriteData()) != null && this.hQL.bMD() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hQM.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bOB();
                } else if (ab.bA(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.iX().a(true, new a.InterfaceC0017a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bOB();
                        }
                    });
                }
                this.hQK.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.fZG.aA(postWriteCallBackData.getSensitiveWords());
                        if (!com.baidu.tbadk.core.util.v.J(this.fZG.bLq())) {
                            ok(true);
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

    public void bOB() {
        this.hQF.g("", this.hQK.bOF(), this.hQL.bMD().linkUrl, this.hQL.bMD().linkUrlCode, this.mLat, this.mLng);
    }
}
