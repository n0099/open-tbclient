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
/* loaded from: classes8.dex */
public class PrivilegeDeskView extends CommonTabHost {
    private LinkedList<h> fCO;
    private int lvl;
    private DLauncher lvm;
    private DLauncher lvn;
    private CustomMessageListener lvo;
    private CustomMessageListener lvp;
    private View.OnClickListener lvq;
    private View.OnClickListener lvr;
    private Context mContext;

    public PrivilegeDeskView(Context context) {
        super(context);
        this.lvl = 0;
        this.lvo = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PrivilegeDeskView.this.lvm.CP(" ");
                    } else {
                        PrivilegeDeskView.this.lvm.bBi();
                    }
                    PrivilegeDeskView.this.dgz();
                }
            }
        };
        this.lvp = new CustomMessageListener(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PrivilegeDeskView.this.lvn.CP(" ");
                    } else {
                        PrivilegeDeskView.this.lvn.bBi();
                    }
                    PrivilegeDeskView.this.dgz();
                }
            }
        };
        this.lvq = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivilegeDeskView.this.hide();
                PrivilegeDeskView.this.b(new com.baidu.tbadk.editortools.a(1, 16, null));
            }
        };
        this.lvr = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.4
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
        this.lvn = (DLauncher) g.a(getContext(), bVar, 6);
        this.lvn.setOnClickListener(this.lvr);
        this.fCO.add(this.lvn);
    }

    private void a(com.baidu.tieba.memberCenter.tail.tool.a aVar) {
        this.lvm = (DLauncher) g.a(getContext(), aVar, 6);
        this.lvm.setOnClickListener(this.lvq);
        this.fCO.add(this.lvm);
    }

    private void gB(Context context) {
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(18);
        this.fCO = new LinkedList<>();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.lvo);
        MessageManager.getInstance().registerListener(this.lvp);
        dgz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.lvo);
        MessageManager.getInstance().unRegisterListener(this.lvp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgz() {
        String text = this.lvm.getText();
        String text2 = this.lvn.getText();
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
        aVar.g(this.fCO);
        b(aVar);
        dgB();
        dgA();
    }

    private void dgA() {
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble())) {
            this.lvn.CP(" ");
        } else {
            this.lvn.bBi();
        }
        dgz();
    }

    private void dgB() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            if (currentAccountObj.getIsSelectTail()) {
                this.lvm.CP(" ");
            } else {
                this.lvm.bBi();
            }
            dgz();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            if (aVar.code == 2) {
                if (aVar.data == null) {
                    this.lvl--;
                } else if (aVar.data instanceof String) {
                    String str = (String) aVar.data;
                    if (TextUtils.isEmpty(str)) {
                        this.lvl--;
                    } else if (TextUtils.isEmpty(str.trim())) {
                        this.lvl++;
                    } else {
                        this.lvl = com.baidu.adp.lib.f.b.toInt(str, 1) + this.lvl;
                    }
                }
                if (this.lvl > 0) {
                    b(new com.baidu.tbadk.editortools.a(2, 18, " "));
                } else {
                    b(new com.baidu.tbadk.editortools.a(2, 18, null));
                }
            }
            if (aVar.code == 1) {
                TiebaStatic.log(new ar("c12612").aq("obj_locate", 2));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lvm.onChangeSkinType(i);
        this.lvn.onChangeSkinType(i);
    }
}
