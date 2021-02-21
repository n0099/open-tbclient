package com.baidu.tieba.memberCenter.tail.tool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
/* loaded from: classes9.dex */
public class TailToolController extends NoPressedLinearLayout implements n {
    private EditorTools acR;
    private int acS;
    private View.OnClickListener lsT;
    private CustomMessageListener ltl;
    private g lts;
    private h ltx;
    private b lty;
    private CustomMessageListener ltz;
    private Context mContext;

    public TailToolController(Context context) {
        super(context);
        this.acS = 0;
        this.ltl = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.mp(bool.booleanValue());
                }
            }
        };
        this.ltz = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.lts.dgz()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.lts.tZ(false);
                }
            }
        };
        this.lsT = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.dgu();
                TailToolController.this.dgt();
            }
        };
        init(context);
    }

    public TailToolController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acS = 0;
        this.ltl = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.mp(bool.booleanValue());
                }
            }
        };
        this.ltz = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.lts.dgz()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.lts.tZ(false);
                }
            }
        };
        this.lsT = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.dgu();
                TailToolController.this.dgt();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ltx = new h((ViewGroup) LayoutInflater.from(context).inflate(R.layout.tail_tool, (ViewGroup) this, true));
        this.lts = new g(context);
        this.lty = new b(context, this.lts, this.lsT);
        this.ltx.c(this.lty);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp(boolean z) {
        if (z) {
            b(new com.baidu.tbadk.editortools.a(2, 16, " "));
        } else {
            b(new com.baidu.tbadk.editortools.a(2, 16, null));
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            currentAccountObj.setIsSelectTail(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgt() {
        hide();
        this.lts.tZ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgu() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.mContext, this.lts.getTails().isEmpty())));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.lts.onAttached();
        MessageManager.getInstance().registerListener(this.ltl);
        MessageManager.getInstance().registerListener(this.ltz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lts.dgy();
        MessageManager.getInstance().unRegisterListener(this.ltl);
        MessageManager.getInstance().unRegisterListener(this.ltz);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        dgv();
    }

    private void dgv() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            mp(currentAccountObj.getIsSelectTail());
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
        this.lts.dgl();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
