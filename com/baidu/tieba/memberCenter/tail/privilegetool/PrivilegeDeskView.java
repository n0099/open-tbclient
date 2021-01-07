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
/* loaded from: classes9.dex */
public class PrivilegeDeskView extends CommonTabHost {
    private LinkedList<h> fDI;
    private DLauncher lpA;
    private CustomMessageListener lpB;
    private CustomMessageListener lpC;
    private View.OnClickListener lpD;
    private View.OnClickListener lpE;
    private int lpy;
    private DLauncher lpz;
    private Context mContext;

    public PrivilegeDeskView(Context context) {
        super(context);
        this.lpy = 0;
        this.lpB = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PrivilegeDeskView.this.lpz.DE(" ");
                    } else {
                        PrivilegeDeskView.this.lpz.bEH();
                    }
                    PrivilegeDeskView.this.dib();
                }
            }
        };
        this.lpC = new CustomMessageListener(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        PrivilegeDeskView.this.lpA.DE(" ");
                    } else {
                        PrivilegeDeskView.this.lpA.bEH();
                    }
                    PrivilegeDeskView.this.dib();
                }
            }
        };
        this.lpD = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivilegeDeskView.this.hide();
                PrivilegeDeskView.this.b(new com.baidu.tbadk.editortools.a(1, 16, null));
            }
        };
        this.lpE = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivilegeDeskView.this.hide();
                PrivilegeDeskView.this.b(new com.baidu.tbadk.editortools.a(1, 12, null));
            }
        };
        gD(context);
        com.baidu.tieba.memberCenter.tail.tool.a aVar = new com.baidu.tieba.memberCenter.tail.tool.a(context, 1);
        a(new com.baidu.tieba.memberCenter.a.b(context));
        a(aVar);
        this.mContext = context;
    }

    private void a(com.baidu.tieba.memberCenter.a.b bVar) {
        this.lpA = (DLauncher) g.a(getContext(), bVar, 6);
        this.lpA.setOnClickListener(this.lpE);
        this.fDI.add(this.lpA);
    }

    private void a(com.baidu.tieba.memberCenter.tail.tool.a aVar) {
        this.lpz = (DLauncher) g.a(getContext(), aVar, 6);
        this.lpz.setOnClickListener(this.lpD);
        this.fDI.add(this.lpz);
    }

    private void gD(Context context) {
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(18);
        this.fDI = new LinkedList<>();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.lpB);
        MessageManager.getInstance().registerListener(this.lpC);
        dib();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.lpB);
        MessageManager.getInstance().unRegisterListener(this.lpC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dib() {
        String text = this.lpz.getText();
        String text2 = this.lpA.getText();
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
        tP(z);
    }

    private void tP(boolean z) {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            currentAccountObj.setIsSelectTail(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.n
    public void init() {
        setShowDelete(false);
        a aVar = new a();
        aVar.g(this.fDI);
        b(aVar);
        did();
        dic();
    }

    private void dic() {
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble())) {
            this.lpA.DE(" ");
        } else {
            this.lpA.bEH();
        }
        dib();
    }

    private void did() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            if (currentAccountObj.getIsSelectTail()) {
                this.lpz.DE(" ");
            } else {
                this.lpz.bEH();
            }
            dib();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            if (aVar.code == 2) {
                if (aVar.data == null) {
                    this.lpy--;
                } else if (aVar.data instanceof String) {
                    String str = (String) aVar.data;
                    if (TextUtils.isEmpty(str)) {
                        this.lpy--;
                    } else if (TextUtils.isEmpty(str.trim())) {
                        this.lpy++;
                    } else {
                        this.lpy = com.baidu.adp.lib.f.b.toInt(str, 1) + this.lpy;
                    }
                }
                if (this.lpy > 0) {
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
        this.lpz.onChangeSkinType(i);
        this.lpA.onChangeSkinType(i);
    }
}
