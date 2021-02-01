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
    private TailData lsf;
    private TailData lsg;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lsh;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lsi;
    private boolean lsd = false;
    private boolean lse = false;
    private com.baidu.adp.framework.listener.a lsj = new com.baidu.adp.framework.listener.a(1003019, CmdConfigSocket.CMD_TAIL_ADD) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.b m37getResultData;
            Integer num;
            a.this.lsd = false;
            if (a.this.lsh != null) {
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    m37getResultData = ((AddTailHttpResponseMessage) responsedMessage).m36getResultData();
                } else {
                    m37getResultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).m37getResultData() : null;
                }
                if (m37getResultData != null) {
                    num = Integer.valueOf(m37getResultData.dfM());
                    if (a.this.lse) {
                        a.this.ED(num.intValue());
                    }
                } else {
                    num = null;
                }
                a.this.lsh.b(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lsk = new com.baidu.adp.framework.listener.a(1003023, CmdConfigSocket.CMD_TAIL_UPDATE) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g m45getResultData;
            a.this.lsd = false;
            if (a.this.lsi != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    m45getResultData = ((UpdateTailHttpResponseMessage) responsedMessage).m44getResultData();
                } else {
                    m45getResultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).m45getResultData() : null;
                }
                a.this.lsi.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m45getResultData != null ? Integer.valueOf(m45getResultData.dfM()) : null);
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
        this.eUY.registerListener(this.lsj);
        this.eUY.registerListener(this.lsk);
        this.lsg = new TailData();
    }

    public void Oi(String str) {
        if (!this.lsd) {
            String Or = d.Or(str);
            if (!StringUtils.isNull(Or)) {
                this.eUY.showToast(Or);
                return;
            }
            String Os = d.Os(str);
            this.lsg.setContent(Os);
            this.lsd = true;
            if (this.lsf == null || this.lsf.getId() <= 0) {
                this.eUY.sendMessage(new AddTailNetMessage(Os, this.lsg.getFontColor(), this.eUY.getString(R.string.tail_default_font)));
            } else {
                this.eUY.sendMessage(new UpdateTailNetMessage(this.lsf.getId(), Os, this.lsg.getFontColor(), this.eUY.getString(R.string.tail_default_font)));
            }
        }
    }

    public void b(int i, String str, String str2, boolean z) {
        this.lsg = new TailData();
        if (i != 0) {
            this.lsf = new TailData();
            this.lsf.setId(i);
            this.lsf.setContent(str);
            this.lsf.setFontColor(str2);
            this.lsg.setId(i);
            this.lsg.setContent(str);
            this.lsg.setFontColor(str2);
            return;
        }
        this.lsg.setContent("");
        this.lsg.setFontColor("7a7c80");
        this.lse = z;
    }

    protected void ED(int i) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
    }

    public boolean dfR() {
        if (this.lsg == null || this.lsg.getFontColor() == null) {
            return false;
        }
        if (this.lsf == null) {
            if (!StringUtils.isNull(this.lsg.getContent()) || !this.lsg.getFontColor().equals("7a7c80")) {
                return true;
            }
        } else if (this.lsf.getContent() == null || this.lsf.getFontColor() == null) {
            return false;
        } else {
            if (!this.lsf.getContent().equals(this.lsg.getContent()) || !this.lsf.getFontColor().equals(this.lsg.getFontColor())) {
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

    public void Oj(String str) {
        this.lsg.setFontColor(str);
    }

    public String dfS() {
        return this.lsg.getFontColor();
    }

    public TailData dfT() {
        return this.lsg;
    }

    public void a(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lsh = aVar;
    }

    public void b(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lsi = aVar;
    }

    public int Ok(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String Ol(String str) {
        while (Ok(str) > 50) {
            str = Om(str);
        }
        return str;
    }

    public String Om(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }

    public boolean dfU() {
        return !StringUtils.isNull(this.lsg.getContent()) && dfR() && StringUtils.isNull(d.Or(this.lsg.getContent()));
    }
}
