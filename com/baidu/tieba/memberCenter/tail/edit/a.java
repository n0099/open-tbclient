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
/* loaded from: classes8.dex */
public class a {
    private TbPageContext<?> eWx;
    private TailData luw;
    private TailData lux;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> luy;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> luz;
    private boolean luu = false;
    private boolean luv = false;
    private com.baidu.adp.framework.listener.a luA = new com.baidu.adp.framework.listener.a(1003019, CmdConfigSocket.CMD_TAIL_ADD) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.b m38getResultData;
            Integer num;
            a.this.luu = false;
            if (a.this.luy != null) {
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    m38getResultData = ((AddTailHttpResponseMessage) responsedMessage).m37getResultData();
                } else {
                    m38getResultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).m38getResultData() : null;
                }
                if (m38getResultData != null) {
                    num = Integer.valueOf(m38getResultData.dgc());
                    if (a.this.luv) {
                        a.this.EG(num.intValue());
                    }
                } else {
                    num = null;
                }
                a.this.luy.b(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
            }
        }
    };
    private com.baidu.adp.framework.listener.a luB = new com.baidu.adp.framework.listener.a(1003023, CmdConfigSocket.CMD_TAIL_UPDATE) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g m46getResultData;
            a.this.luu = false;
            if (a.this.luz != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    m46getResultData = ((UpdateTailHttpResponseMessage) responsedMessage).m45getResultData();
                } else {
                    m46getResultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).m46getResultData() : null;
                }
                a.this.luz.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m46getResultData != null ? Integer.valueOf(m46getResultData.dgc()) : null);
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eWx = tbPageContext;
        this.eWx.registerListener(this.luA);
        this.eWx.registerListener(this.luB);
        this.lux = new TailData();
    }

    public void Op(String str) {
        if (!this.luu) {
            String Oy = d.Oy(str);
            if (!StringUtils.isNull(Oy)) {
                this.eWx.showToast(Oy);
                return;
            }
            String Oz = d.Oz(str);
            this.lux.setContent(Oz);
            this.luu = true;
            if (this.luw == null || this.luw.getId() <= 0) {
                this.eWx.sendMessage(new AddTailNetMessage(Oz, this.lux.getFontColor(), this.eWx.getString(R.string.tail_default_font)));
            } else {
                this.eWx.sendMessage(new UpdateTailNetMessage(this.luw.getId(), Oz, this.lux.getFontColor(), this.eWx.getString(R.string.tail_default_font)));
            }
        }
    }

    public void b(int i, String str, String str2, boolean z) {
        this.lux = new TailData();
        if (i != 0) {
            this.luw = new TailData();
            this.luw.setId(i);
            this.luw.setContent(str);
            this.luw.setFontColor(str2);
            this.lux.setId(i);
            this.lux.setContent(str);
            this.lux.setFontColor(str2);
            return;
        }
        this.lux.setContent("");
        this.lux.setFontColor("7a7c80");
        this.luv = z;
    }

    protected void EG(int i) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
    }

    public boolean dgh() {
        if (this.lux == null || this.lux.getFontColor() == null) {
            return false;
        }
        if (this.luw == null) {
            if (!StringUtils.isNull(this.lux.getContent()) || !this.lux.getFontColor().equals("7a7c80")) {
                return true;
            }
        } else if (this.luw.getContent() == null || this.luw.getFontColor() == null) {
            return false;
        } else {
            if (!this.luw.getContent().equals(this.lux.getContent()) || !this.luw.getFontColor().equals(this.lux.getFontColor())) {
                return true;
            }
        }
        return false;
    }

    public boolean EH(int i) {
        return i == 50;
    }

    public boolean EI(int i) {
        return i > 50;
    }

    public void Oq(String str) {
        this.lux.setFontColor(str);
    }

    public String dgi() {
        return this.lux.getFontColor();
    }

    public TailData dgj() {
        return this.lux;
    }

    public void a(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.luy = aVar;
    }

    public void b(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.luz = aVar;
    }

    public int Or(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String Os(String str) {
        while (Or(str) > 50) {
            str = Ot(str);
        }
        return str;
    }

    public String Ot(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }

    public boolean dgk() {
        return !StringUtils.isNull(this.lux.getContent()) && dgh() && StringUtils.isNull(d.Oy(this.lux.getContent()));
    }
}
