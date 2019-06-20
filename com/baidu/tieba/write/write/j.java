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
import com.baidu.tieba.R;
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
    private static final Pattern jNR = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b ggg;
    private WriteUrlModel jNN;
    private k jNS;
    private com.baidu.tieba.write.model.a jNT;
    private com.baidu.tieba.write.transmit.model.a jNU;
    private com.baidu.tbadk.core.view.b jNV;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == R.id.icon_invoke_link) {
                    j.this.czE();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == R.id.url_edit_back_view) {
                    j.this.czD();
                }
            }
        }
    };
    private View.OnClickListener jNW = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == R.id.url_add) {
                TiebaStatic.log(new am("c12163"));
                String czR = j.this.jNS.czR();
                if (j.jNR.matcher(czR).matches()) {
                    j.this.czD();
                    j.this.jNT.FQ(czR);
                    j.this.jNS.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.jNS.czS();
            }
        }
    };
    private TextWatcher jNX = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.jNS.czJ();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.ggg != null) {
                if (!j.this.ggg.cwg()) {
                    j.this.rU(false);
                }
                j.this.ggg.rL(false);
            }
        }
    };
    private DialogInterface.OnCancelListener jNY = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.jNU != null) {
                j.this.jNU.bmr();
            }
        }
    };
    private a.InterfaceC0430a jEd = new a.InterfaceC0430a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0430a
        public void onError() {
            j.this.eA(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0430a
        public void g(List<SimpleForum> list, int i) {
            j.this.eA(list);
        }
    };
    private a.InterfaceC0015a duc = new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d csE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            j.this.jNS.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.ggg.aI(null);
                j.this.ggg.rK(false);
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
                    j.this.ggg.aI(postWriteCallBackData.getSensitiveWords());
                    j.this.ggg.FG(postWriteCallBackData.getErrorString());
                    if (!v.aa(j.this.ggg.cwd())) {
                        j.this.rU(true);
                    }
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.jNS.l(postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.alA());
                    if (!com.baidu.tbadk.v.a.rc(xVar.alz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.alz())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.jNV = null;
        this.mContext = tbPageContext;
        this.jNS = kVar;
        this.jNT = aVar;
        this.jNN = writeUrlModel;
        this.jNS.ac(this.mClickListener);
        this.jNS.ad(this.jNW);
        this.jNS.f(this.jNX);
        czE();
        this.jNV = new com.baidu.tbadk.core.view.b(this.mContext);
        this.jNV.e(this.jNY);
        czC();
        this.jNN.b(this.csE);
        this.ggg = new com.baidu.tieba.write.b();
        this.ggg.Cb(R.color.cp_btn_a);
        this.ggg.Cc(R.color.cp_cont_h_alpha85);
    }

    private void czC() {
        this.jNU = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.jNU.a(this.jEd);
        if (this.jNN.getWriteData() != null) {
            this.jNU.setForumId(this.jNN.getWriteData().getForumId());
        }
    }

    protected void czD() {
        this.jNS.czQ();
    }

    protected void czE() {
        this.jNS.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(List<SimpleForum> list) {
        WriteData writeData = this.jNN.getWriteData();
        if (writeData != null) {
            this.jNV.ef(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (v.Z(list) > 0) {
                for (SimpleForum simpleForum : list) {
                    if (simpleForum != null && simpleForum.id != null && !StringUtils.isNull(simpleForum.name) && simpleForum.id.longValue() != com.baidu.adp.lib.g.b.c(writeData.getForumId(), 0L)) {
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

    public void cne() {
        if (ab.cv(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.hO().a(true, this.duc);
        }
    }

    public void destroy() {
        if (this.jNU != null) {
            this.jNU.destroy();
        }
        if (this.jNT != null) {
            this.jNT.destroy();
        }
        if (this.jNN != null) {
            this.jNN.cancelLoadData();
        }
    }

    public void aZs() {
        this.jNU.setThreadContent(this.jNS.czK());
        this.jNU.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU(boolean z) {
        if (this.jNS.czM() != null && this.jNS.czK() != null) {
            int selectionEnd = this.jNS.czM().getSelectionEnd();
            SpannableStringBuilder b = this.ggg.b(this.jNS.czM().getText());
            if (b != null) {
                this.ggg.rL(true);
                this.jNS.czM().setText(b);
                if (z && this.ggg.cwe() >= 0) {
                    this.jNS.czM().requestFocus();
                    this.jNS.czM().setSelection(this.ggg.cwe());
                } else {
                    this.jNS.czM().setSelection(selectionEnd);
                }
                this.ggg.rK(this.ggg.cwe() >= 0);
            }
        }
    }

    public boolean czF() {
        if (this.ggg.cwf()) {
            this.mContext.showToast(this.ggg.cwh());
            rU(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.ggg.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.jNN.getWriteData()) != null && this.jNT.cxF() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.jNU.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    czG();
                } else if (ab.cv(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.hO().a(true, new a.InterfaceC0015a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.czG();
                        }
                    });
                }
                this.jNS.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.ggg.aI(postWriteCallBackData.getSensitiveWords());
                        if (!v.aa(this.ggg.cwd())) {
                            rU(true);
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

    public void czG() {
        this.jNN.g("", this.jNS.czK(), this.jNT.cxF().linkUrl, this.jNT.cxF().linkUrlCode, this.mLat, this.mLng);
    }
}
