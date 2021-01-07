package com.baidu.tieba.memberCenter.tail.edit;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.a.d;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.g;
import com.baidu.tieba.memberCenter.tail.message.AddTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailSocketResponseMessage;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext<?> eXu;
    private TailData loJ;
    private TailData loK;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> loL;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> loM;
    private boolean loH = false;
    private boolean loI = false;
    private com.baidu.adp.framework.listener.a loN = new com.baidu.adp.framework.listener.a(1003019, CmdConfigSocket.CMD_TAIL_ADD) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.b m43getResultData;
            Integer num;
            a.this.loH = false;
            if (a.this.loL != null) {
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    m43getResultData = ((AddTailHttpResponseMessage) responsedMessage).m42getResultData();
                } else {
                    m43getResultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).m43getResultData() : null;
                }
                if (m43getResultData != null) {
                    num = Integer.valueOf(m43getResultData.dhE());
                    if (a.this.loI) {
                        a.this.FR(num.intValue());
                    }
                } else {
                    num = null;
                }
                a.this.loL.b(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
            }
        }
    };
    private com.baidu.adp.framework.listener.a loO = new com.baidu.adp.framework.listener.a(1003023, CmdConfigSocket.CMD_TAIL_UPDATE) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g m51getResultData;
            a.this.loH = false;
            if (a.this.loM != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    m51getResultData = ((UpdateTailHttpResponseMessage) responsedMessage).m50getResultData();
                } else {
                    m51getResultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).m51getResultData() : null;
                }
                a.this.loM.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m51getResultData != null ? Integer.valueOf(m51getResultData.dhE()) : null);
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
        this.eXu.registerListener(this.loN);
        this.eXu.registerListener(this.loO);
        this.loK = new TailData();
    }

    public void OB(String str) {
        if (!this.loH) {
            String OK = d.OK(str);
            if (!StringUtils.isNull(OK)) {
                this.eXu.showToast(OK);
                return;
            }
            String OL = d.OL(str);
            this.loK.setContent(OL);
            this.loH = true;
            if (this.loJ == null || this.loJ.getId() <= 0) {
                this.eXu.sendMessage(new AddTailNetMessage(OL, this.loK.getFontColor(), this.eXu.getString(R.string.tail_default_font)));
            } else {
                this.eXu.sendMessage(new UpdateTailNetMessage(this.loJ.getId(), OL, this.loK.getFontColor(), this.eXu.getString(R.string.tail_default_font)));
            }
        }
    }

    public void b(int i, String str, String str2, boolean z) {
        this.loK = new TailData();
        if (i != 0) {
            this.loJ = new TailData();
            this.loJ.setId(i);
            this.loJ.setContent(str);
            this.loJ.setFontColor(str2);
            this.loK.setId(i);
            this.loK.setContent(str);
            this.loK.setFontColor(str2);
            return;
        }
        this.loK.setContent("");
        this.loK.setFontColor("7a7c80");
        this.loI = z;
    }

    protected void FR(int i) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
    }

    public boolean dhJ() {
        if (this.loK == null || this.loK.getFontColor() == null) {
            return false;
        }
        if (this.loJ == null) {
            if (!StringUtils.isNull(this.loK.getContent()) || !this.loK.getFontColor().equals("7a7c80")) {
                return true;
            }
        } else if (this.loJ.getContent() == null || this.loJ.getFontColor() == null) {
            return false;
        } else {
            if (!this.loJ.getContent().equals(this.loK.getContent()) || !this.loJ.getFontColor().equals(this.loK.getFontColor())) {
                return true;
            }
        }
        return false;
    }

    public boolean FS(int i) {
        return i == 50;
    }

    public boolean FT(int i) {
        return i > 50;
    }

    public void OC(String str) {
        this.loK.setFontColor(str);
    }

    public String dhK() {
        return this.loK.getFontColor();
    }

    public TailData dhL() {
        return this.loK;
    }

    public void a(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.loL = aVar;
    }

    public void b(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.loM = aVar;
    }

    public int OD(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String OE(String str) {
        while (OD(str) > 50) {
            str = OF(str);
        }
        return str;
    }

    public String OF(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }

    public boolean dhM() {
        return !StringUtils.isNull(this.loK.getContent()) && dhJ() && StringUtils.isNull(d.OK(this.loK.getContent()));
    }
}
