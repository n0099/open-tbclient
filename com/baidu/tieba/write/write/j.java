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
    private static final Pattern hJx = Pattern.compile("[ ]*http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?#%&=]*)?", 2);
    public com.baidu.tieba.write.b fSg;
    private com.baidu.tieba.write.transmit.model.a hJA;
    private com.baidu.tbadk.core.view.d hJB;
    private WriteUrlModel hJt;
    private k hJy;
    private com.baidu.tieba.write.model.a hJz;
    private TbPageContext mContext;
    public String mLat;
    public String mLng;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() != 0) {
                if (view.getId() == e.g.icon_invoke_link) {
                    j.this.bLo();
                    TiebaStatic.log(new am("c12169"));
                }
                if (view.getId() == e.g.url_edit_back_view) {
                    j.this.bLn();
                }
            }
        }
    };
    private View.OnClickListener hJC = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view.getId() == e.g.url_add) {
                TiebaStatic.log(new am("c12163"));
                String bLB = j.this.hJy.bLB();
                if (j.hJx.matcher(bLB).matches()) {
                    j.this.bLn();
                    j.this.hJz.ws(bLB);
                    j.this.hJy.a(null, true);
                    return;
                }
                TiebaStatic.log(new am("c12164"));
                j.this.hJy.bLC();
            }
        }
    };
    private TextWatcher hJD = new TextWatcher() { // from class: com.baidu.tieba.write.write.j.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            j.this.hJy.bLt();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (j.this.fSg != null) {
                if (!j.this.fSg.bIh()) {
                    j.this.nU(false);
                }
                j.this.fSg.nL(false);
            }
        }
    };
    private DialogInterface.OnCancelListener hJE = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.j.4
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (j.this.hJA != null) {
                j.this.hJA.ayC();
            }
        }
    };
    private a.InterfaceC0261a hAm = new a.InterfaceC0261a() { // from class: com.baidu.tieba.write.write.j.5
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0261a
        public void onError() {
            j.this.dW(null);
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0261a
        public void r(List<SimpleForum> list, int i) {
            j.this.dW(list);
        }
    };
    private a.InterfaceC0014a bGy = new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.6
        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
        public void b(int i, String str, Address address) {
            if (i == 0 && address != null) {
                j.this.mLat = String.valueOf(address.getLatitude());
                j.this.mLng = String.valueOf(address.getLongitude());
            }
        }
    };
    private final NewWriteModel.d aRr = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.j.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            j.this.hJy.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                j.this.fSg.aA(null);
                j.this.fSg.nK(false);
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
                    j.this.fSg.aA(postWriteCallBackData.getSensitiveWords());
                    j.this.fSg.wi(postWriteCallBackData.getErrorString());
                    if (!com.baidu.tbadk.core.util.v.z(j.this.fSg.bIe())) {
                        j.this.nU(true);
                    }
                } else if ((vVar == null || writeData == null || vVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    j.this.hJy.l(postWriteCallBackData);
                } else if (vVar != null && writeData != null && vVar.getVcode_pic_url() != null) {
                    writeData.setVcodeMD5(vVar.getVcode_md5());
                    writeData.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData.setVcodeExtra(vVar.DF());
                    if (!com.baidu.tbadk.q.a.il(vVar.DE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(j.this.mContext.getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.DE())));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(j.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public j(TbPageContext tbPageContext, k kVar, com.baidu.tieba.write.model.a aVar, WriteUrlModel writeUrlModel) {
        this.hJB = null;
        this.mContext = tbPageContext;
        this.hJy = kVar;
        this.hJz = aVar;
        this.hJt = writeUrlModel;
        this.hJy.X(this.mClickListener);
        this.hJy.Y(this.hJC);
        this.hJy.e(this.hJD);
        bLo();
        this.hJB = new com.baidu.tbadk.core.view.d(this.mContext);
        this.hJB.d(this.hJE);
        bLm();
        this.hJt.b(this.aRr);
        this.fSg = new com.baidu.tieba.write.b();
        this.fSg.vI(e.d.cp_cont_i);
        this.fSg.vJ(e.d.cp_cont_h_alpha85);
    }

    private void bLm() {
        this.hJA = new com.baidu.tieba.write.transmit.model.a(this.mContext.getUniqueId());
        this.hJA.a(this.hAm);
        if (this.hJt.getWriteData() != null) {
            this.hJA.setForumId(this.hJt.getWriteData().getForumId());
        }
    }

    protected void bLn() {
        this.hJy.bLA();
    }

    protected void bLo() {
        this.hJy.b((com.baidu.tieba.write.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(List<SimpleForum> list) {
        WriteData writeData = this.hJt.getWriteData();
        if (writeData != null) {
            this.hJB.aZ(false);
            ArrayList<TransmitForumData> arrayList = new ArrayList<>();
            if (!StringUtils.isNull(writeData.getForumId()) && !writeData.getForumId().equals("0") && !StringUtils.isNull(writeData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(com.baidu.adp.lib.g.b.d(writeData.getForumId(), 0L), writeData.getForumName(), true, 0);
                if (arrayList != null) {
                    arrayList.add(transmitForumData);
                }
            }
            if (com.baidu.tbadk.core.util.v.y(list) > 0) {
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

    public void bzu() {
        if (ab.br(this.mContext.getPageActivity())) {
            com.baidu.adp.lib.d.a.iH().a(true, this.bGy);
        }
    }

    public void destroy() {
        if (this.hJA != null) {
            this.hJA.destroy();
        }
        if (this.hJz != null) {
            this.hJz.destroy();
        }
        if (this.hJt != null) {
            this.hJt.cancelLoadData();
        }
    }

    public void amq() {
        this.hJA.setThreadContent(this.hJy.bLu());
        this.hJA.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU(boolean z) {
        if (this.hJy.bLw() != null && this.hJy.bLu() != null) {
            int selectionEnd = this.hJy.bLw().getSelectionEnd();
            SpannableStringBuilder b = this.fSg.b(this.hJy.bLw().getText());
            if (b != null) {
                this.fSg.nL(true);
                this.hJy.bLw().setText(b);
                if (z && this.fSg.bIf() >= 0) {
                    this.hJy.bLw().requestFocus();
                    this.hJy.bLw().setSelection(this.fSg.bIf());
                } else {
                    this.hJy.bLw().setSelection(selectionEnd);
                }
                this.fSg.nK(this.fSg.bIf() >= 0);
            }
        }
    }

    public boolean bLp() {
        if (this.fSg.bIg()) {
            this.mContext.showToast(this.fSg.bIi());
            nU(true);
            return true;
        }
        return false;
    }

    public void onChangeSkinType() {
        this.fSg.onChangeSkinType();
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
            } else if (i == 25013 && (writeData = this.hJt.getWriteData()) != null && this.hJz.bJr() != null) {
                if (intent != null) {
                    writeData.setTransmitForumData(intent.getStringExtra(TransmitForumActivityConfig.KEY_FORUM_LIST_SELECTED));
                }
                writeData.setForumId("0");
                writeData.setCanNoForum(true);
                writeData.setRecommendExt(this.hJA.getRecommendExt());
                if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
                    bLq();
                } else if (ab.br(this.mContext.getPageActivity())) {
                    com.baidu.adp.lib.d.a.iH().a(true, new a.InterfaceC0014a() { // from class: com.baidu.tieba.write.write.j.8
                        @Override // com.baidu.adp.lib.d.a.InterfaceC0014a
                        public void b(int i3, String str, Address address) {
                            if (i3 == 0 && address != null) {
                                j.this.mLat = String.valueOf(address.getLatitude());
                                j.this.mLng = String.valueOf(address.getLongitude());
                            }
                            j.this.bLq();
                        }
                    });
                }
                this.hJy.showLoadingDialog();
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        this.mContext.showToast(postWriteCallBackData.getErrorString());
                        this.fSg.aA(postWriteCallBackData.getSensitiveWords());
                        if (!com.baidu.tbadk.core.util.v.z(this.fSg.bIe())) {
                            nU(true);
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

    public void bLq() {
        this.hJt.g("", this.hJy.bLu(), this.hJz.bJr().linkUrl, this.hJz.bJr().linkUrlCode, this.mLat, this.mLng);
    }
}
