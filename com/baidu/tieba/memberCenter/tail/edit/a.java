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
    private TbPageContext<?> eUY;
    private TailData lst;
    private TailData lsu;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lsv;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lsw;
    private boolean lsr = false;
    private boolean lss = false;
    private com.baidu.adp.framework.listener.a lsx = new com.baidu.adp.framework.listener.a(1003019, CmdConfigSocket.CMD_TAIL_ADD) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.b m37getResultData;
            Integer num;
            a.this.lsr = false;
            if (a.this.lsv != null) {
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    m37getResultData = ((AddTailHttpResponseMessage) responsedMessage).m36getResultData();
                } else {
                    m37getResultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).m37getResultData() : null;
                }
                if (m37getResultData != null) {
                    num = Integer.valueOf(m37getResultData.dfT());
                    if (a.this.lss) {
                        a.this.ED(num.intValue());
                    }
                } else {
                    num = null;
                }
                a.this.lsv.b(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lsy = new com.baidu.adp.framework.listener.a(1003023, CmdConfigSocket.CMD_TAIL_UPDATE) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g m45getResultData;
            a.this.lsr = false;
            if (a.this.lsw != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    m45getResultData = ((UpdateTailHttpResponseMessage) responsedMessage).m44getResultData();
                } else {
                    m45getResultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).m45getResultData() : null;
                }
                a.this.lsw.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m45getResultData != null ? Integer.valueOf(m45getResultData.dfT()) : null);
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
        this.eUY.registerListener(this.lsx);
        this.eUY.registerListener(this.lsy);
        this.lsu = new TailData();
    }

    public void Oj(String str) {
        if (!this.lsr) {
            String Os = d.Os(str);
            if (!StringUtils.isNull(Os)) {
                this.eUY.showToast(Os);
                return;
            }
            String Ot = d.Ot(str);
            this.lsu.setContent(Ot);
            this.lsr = true;
            if (this.lst == null || this.lst.getId() <= 0) {
                this.eUY.sendMessage(new AddTailNetMessage(Ot, this.lsu.getFontColor(), this.eUY.getString(R.string.tail_default_font)));
            } else {
                this.eUY.sendMessage(new UpdateTailNetMessage(this.lst.getId(), Ot, this.lsu.getFontColor(), this.eUY.getString(R.string.tail_default_font)));
            }
        }
    }

    public void b(int i, String str, String str2, boolean z) {
        this.lsu = new TailData();
        if (i != 0) {
            this.lst = new TailData();
            this.lst.setId(i);
            this.lst.setContent(str);
            this.lst.setFontColor(str2);
            this.lsu.setId(i);
            this.lsu.setContent(str);
            this.lsu.setFontColor(str2);
            return;
        }
        this.lsu.setContent("");
        this.lsu.setFontColor("7a7c80");
        this.lss = z;
    }

    protected void ED(int i) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
    }

    public boolean dfY() {
        if (this.lsu == null || this.lsu.getFontColor() == null) {
            return false;
        }
        if (this.lst == null) {
            if (!StringUtils.isNull(this.lsu.getContent()) || !this.lsu.getFontColor().equals("7a7c80")) {
                return true;
            }
        } else if (this.lst.getContent() == null || this.lst.getFontColor() == null) {
            return false;
        } else {
            if (!this.lst.getContent().equals(this.lsu.getContent()) || !this.lst.getFontColor().equals(this.lsu.getFontColor())) {
                return true;
            }
        }
        return false;
    }

    public boolean EE(int i) {
        return i == 50;
    }

    public boolean EF(int i) {
        return i > 50;
    }

    public void Ok(String str) {
        this.lsu.setFontColor(str);
    }

    public String dfZ() {
        return this.lsu.getFontColor();
    }

    public TailData dga() {
        return this.lsu;
    }

    public void a(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lsv = aVar;
    }

    public void b(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lsw = aVar;
    }

    public int Ol(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String Om(String str) {
        while (Ol(str) > 50) {
            str = On(str);
        }
        return str;
    }

    public String On(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }

    public boolean dgb() {
        return !StringUtils.isNull(this.lsu.getContent()) && dfY() && StringUtils.isNull(d.Os(this.lsu.getContent()));
    }
}
