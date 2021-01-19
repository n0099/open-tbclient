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
    private TbPageContext<?> eSJ;
    private TailData ljZ;
    private TailData lka;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lkb;
    private com.baidu.tieba.memberCenter.tail.a.a<Integer> lkc;
    private boolean ljX = false;
    private boolean ljY = false;
    private com.baidu.adp.framework.listener.a lkd = new com.baidu.adp.framework.listener.a(1003019, CmdConfigSocket.CMD_TAIL_ADD) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.memberCenter.tail.data.b m38getResultData;
            Integer num;
            a.this.ljX = false;
            if (a.this.lkb != null) {
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    m38getResultData = ((AddTailHttpResponseMessage) responsedMessage).m37getResultData();
                } else {
                    m38getResultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).m38getResultData() : null;
                }
                if (m38getResultData != null) {
                    num = Integer.valueOf(m38getResultData.ddM());
                    if (a.this.ljY) {
                        a.this.El(num.intValue());
                    }
                } else {
                    num = null;
                }
                a.this.lkb.b(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
            }
        }
    };
    private com.baidu.adp.framework.listener.a lke = new com.baidu.adp.framework.listener.a(1003023, CmdConfigSocket.CMD_TAIL_UPDATE) { // from class: com.baidu.tieba.memberCenter.tail.edit.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g m46getResultData;
            a.this.ljX = false;
            if (a.this.lkc != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    m46getResultData = ((UpdateTailHttpResponseMessage) responsedMessage).m45getResultData();
                } else {
                    m46getResultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).m46getResultData() : null;
                }
                a.this.lkc.b(responsedMessage.hasError(), responsedMessage.getErrorString(), m46getResultData != null ? Integer.valueOf(m46getResultData.ddM()) : null);
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eSJ = tbPageContext;
        this.eSJ.registerListener(this.lkd);
        this.eSJ.registerListener(this.lke);
        this.lka = new TailData();
    }

    public void Nu(String str) {
        if (!this.ljX) {
            String ND = d.ND(str);
            if (!StringUtils.isNull(ND)) {
                this.eSJ.showToast(ND);
                return;
            }
            String NE = d.NE(str);
            this.lka.setContent(NE);
            this.ljX = true;
            if (this.ljZ == null || this.ljZ.getId() <= 0) {
                this.eSJ.sendMessage(new AddTailNetMessage(NE, this.lka.getFontColor(), this.eSJ.getString(R.string.tail_default_font)));
            } else {
                this.eSJ.sendMessage(new UpdateTailNetMessage(this.ljZ.getId(), NE, this.lka.getFontColor(), this.eSJ.getString(R.string.tail_default_font)));
            }
        }
    }

    public void b(int i, String str, String str2, boolean z) {
        this.lka = new TailData();
        if (i != 0) {
            this.ljZ = new TailData();
            this.ljZ.setId(i);
            this.ljZ.setContent(str);
            this.ljZ.setFontColor(str2);
            this.lka.setId(i);
            this.lka.setContent(str);
            this.lka.setFontColor(str2);
            return;
        }
        this.lka.setContent("");
        this.lka.setFontColor("7a7c80");
        this.ljY = z;
    }

    protected void El(int i) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
    }

    public boolean ddR() {
        if (this.lka == null || this.lka.getFontColor() == null) {
            return false;
        }
        if (this.ljZ == null) {
            if (!StringUtils.isNull(this.lka.getContent()) || !this.lka.getFontColor().equals("7a7c80")) {
                return true;
            }
        } else if (this.ljZ.getContent() == null || this.ljZ.getFontColor() == null) {
            return false;
        } else {
            if (!this.ljZ.getContent().equals(this.lka.getContent()) || !this.ljZ.getFontColor().equals(this.lka.getFontColor())) {
                return true;
            }
        }
        return false;
    }

    public boolean Em(int i) {
        return i == 50;
    }

    public boolean En(int i) {
        return i > 50;
    }

    public void Nv(String str) {
        this.lka.setFontColor(str);
    }

    public String ddS() {
        return this.lka.getFontColor();
    }

    public TailData ddT() {
        return this.lka;
    }

    public void a(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lkb = aVar;
    }

    public void b(com.baidu.tieba.memberCenter.tail.a.a<Integer> aVar) {
        this.lkc = aVar;
    }

    public int Nw(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String Nx(String str) {
        while (Nw(str) > 50) {
            str = Ny(str);
        }
        return str;
    }

    public String Ny(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }

    public boolean ddU() {
        return !StringUtils.isNull(this.lka.getContent()) && ddR() && StringUtils.isNull(d.ND(this.lka.getContent()));
    }
}
