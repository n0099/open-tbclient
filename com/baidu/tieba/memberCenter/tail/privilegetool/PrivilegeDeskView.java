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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.g;
import com.baidu.tbadk.editortools.h;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class PrivilegeDeskView extends CommonTabHost {
    private LinkedList<h> fza;
    private int lkO;
    private DLauncher lkP;
    private DLauncher lkQ;
    private CustomMessageListener lkR;
    private CustomMessageListener lkS;
    private View.OnClickListener lkT;
    private View.OnClickListener lkU;
    private Context mContext;

    public PrivilegeDeskView(Context context) {
        super(context);
        this.lkO = 0;
        this.lkR = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PrivilegeDeskView.this.lkP.Ct(" ");
                    } else {
                        PrivilegeDeskView.this.lkP.bAN();
                    }
                    PrivilegeDeskView.this.dej();
                }
            }
        };
        this.lkS = new CustomMessageListener(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PrivilegeDeskView.this.lkQ.Ct(" ");
                    } else {
                        PrivilegeDeskView.this.lkQ.bAN();
                    }
                    PrivilegeDeskView.this.dej();
                }
            }
        };
        this.lkT = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivilegeDeskView.this.hide();
                PrivilegeDeskView.this.b(new com.baidu.tbadk.editortools.a(1, 16, null));
            }
        };
        this.lkU = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivilegeDeskView.this.hide();
                PrivilegeDeskView.this.b(new com.baidu.tbadk.editortools.a(1, 12, null));
            }
        };
        gB(context);
        com.baidu.tieba.memberCenter.tail.tool.a aVar = new com.baidu.tieba.memberCenter.tail.tool.a(context, 1);
        a(new com.baidu.tieba.memberCenter.a.b(context));
        a(aVar);
        this.mContext = context;
    }

    private void a(com.baidu.tieba.memberCenter.a.b bVar) {
        this.lkQ = (DLauncher) g.a(getContext(), bVar, 6);
        this.lkQ.setOnClickListener(this.lkU);
        this.fza.add(this.lkQ);
    }

    private void a(com.baidu.tieba.memberCenter.tail.tool.a aVar) {
        this.lkP = (DLauncher) g.a(getContext(), aVar, 6);
        this.lkP.setOnClickListener(this.lkT);
        this.fza.add(this.lkP);
    }

    private void gB(Context context) {
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(18);
        this.fza = new LinkedList<>();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.lkR);
        MessageManager.getInstance().registerListener(this.lkS);
        dej();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.lkR);
        MessageManager.getInstance().unRegisterListener(this.lkS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dej() {
        String text = this.lkP.getText();
        String text2 = this.lkQ.getText();
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
        tL(z);
    }

    private void tL(boolean z) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            currentAccountObj.setIsSelectTail(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void init() {
        setShowDelete(false);
        a aVar = new a();
        aVar.g(this.fza);
        b(aVar);
        del();
        dek();
    }

    private void dek() {
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble())) {
            this.lkQ.Ct(" ");
        } else {
            this.lkQ.bAN();
        }
        dej();
    }

    private void del() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            if (currentAccountObj.getIsSelectTail()) {
                this.lkP.Ct(" ");
            } else {
                this.lkP.bAN();
            }
            dej();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            if (aVar.code == 2) {
                if (aVar.data == null) {
                    this.lkO--;
                } else if (aVar.data instanceof String) {
                    String str = (String) aVar.data;
                    if (TextUtils.isEmpty(str)) {
                        this.lkO--;
                    } else if (TextUtils.isEmpty(str.trim())) {
                        this.lkO++;
                    } else {
                        this.lkO = com.baidu.adp.lib.f.b.toInt(str, 1) + this.lkO;
                    }
                }
                if (this.lkO > 0) {
                    b(new com.baidu.tbadk.editortools.a(2, 18, " "));
                } else {
                    b(new com.baidu.tbadk.editortools.a(2, 18, null));
                }
            }
            if (aVar.code == 1) {
                TiebaStatic.log(new aq("c12612").an("obj_locate", 2));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lkP.onChangeSkinType(i);
        this.lkQ.onChangeSkinType(i);
    }
}
