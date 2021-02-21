package com.baidu.tieba.memberCenter.tail.privilegetool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.g;
import com.baidu.tbadk.editortools.h;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class PrivilegeDeskView extends CommonTabHost {
    private LinkedList<h> fBp;
    private int lti;
    private DLauncher ltj;
    private DLauncher ltk;
    private CustomMessageListener ltl;
    private CustomMessageListener ltm;
    private View.OnClickListener ltn;
    private View.OnClickListener lto;
    private Context mContext;

    public PrivilegeDeskView(Context context) {
        super(context);
        this.lti = 0;
        this.ltl = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PrivilegeDeskView.this.ltj.CI(" ");
                    } else {
                        PrivilegeDeskView.this.ltj.bBf();
                    }
                    PrivilegeDeskView.this.dgq();
                }
            }
        };
        this.ltm = new CustomMessageListener(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PrivilegeDeskView.this.ltk.CI(" ");
                    } else {
                        PrivilegeDeskView.this.ltk.bBf();
                    }
                    PrivilegeDeskView.this.dgq();
                }
            }
        };
        this.ltn = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivilegeDeskView.this.hide();
                PrivilegeDeskView.this.b(new com.baidu.tbadk.editortools.a(1, 16, null));
            }
        };
        this.lto = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivilegeDeskView.this.hide();
                PrivilegeDeskView.this.b(new com.baidu.tbadk.editortools.a(1, 12, null));
            }
        };
        gC(context);
        com.baidu.tieba.memberCenter.tail.tool.a aVar = new com.baidu.tieba.memberCenter.tail.tool.a(context, 1);
        a(new com.baidu.tieba.memberCenter.a.b(context));
        a(aVar);
        this.mContext = context;
    }

    private void a(com.baidu.tieba.memberCenter.a.b bVar) {
        this.ltk = (DLauncher) g.a(getContext(), bVar, 6);
        this.ltk.setOnClickListener(this.lto);
        this.fBp.add(this.ltk);
    }

    private void a(com.baidu.tieba.memberCenter.tail.tool.a aVar) {
        this.ltj = (DLauncher) g.a(getContext(), aVar, 6);
        this.ltj.setOnClickListener(this.ltn);
        this.fBp.add(this.ltj);
    }

    private void gC(Context context) {
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(18);
        this.fBp = new LinkedList<>();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ltl);
        MessageManager.getInstance().registerListener(this.ltm);
        dgq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ltl);
        MessageManager.getInstance().unRegisterListener(this.ltm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgq() {
        String text = this.ltj.getText();
        String text2 = this.ltk.getText();
        boolean z = false;
        if (text != null && !text.equals("")) {
            z = true;
            b(new com.baidu.tbadk.editortools.a(2, 18, " "));
            b(new com.baidu.tbadk.editortools.a(2, 16, " "));
        } else if (text2 != null && !text2.equals("")) {
            b(new com.baidu.tbadk.editortools.a(2, 18, " "));
        } else {
            b(new com.baidu.tbadk.editortools.a(2, 18, null));
        }
        tY(z);
    }

    private void tY(boolean z) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            currentAccountObj.setIsSelectTail(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void init() {
        setShowDelete(false);
        a aVar = new a();
        aVar.g(this.fBp);
        b(aVar);
        dgs();
        dgr();
    }

    private void dgr() {
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble())) {
            this.ltk.CI(" ");
        } else {
            this.ltk.bBf();
        }
        dgq();
    }

    private void dgs() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            if (currentAccountObj.getIsSelectTail()) {
                this.ltj.CI(" ");
            } else {
                this.ltj.bBf();
            }
            dgq();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            if (aVar.code == 2) {
                if (aVar.data == null) {
                    this.lti--;
                } else if (aVar.data instanceof String) {
                    String str = (String) aVar.data;
                    if (TextUtils.isEmpty(str)) {
                        this.lti--;
                    } else if (TextUtils.isEmpty(str.trim())) {
                        this.lti++;
                    } else {
                        this.lti = com.baidu.adp.lib.f.b.toInt(str, 1) + this.lti;
                    }
                }
                if (this.lti > 0) {
                    b(new com.baidu.tbadk.editortools.a(2, 18, " "));
                } else {
                    b(new com.baidu.tbadk.editortools.a(2, 18, null));
                }
            }
            if (aVar.code == 1) {
                TiebaStatic.log(new ar("c12612").ap("obj_locate", 2));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ltj.onChangeSkinType(i);
        this.ltk.onChangeSkinType(i);
    }
}
