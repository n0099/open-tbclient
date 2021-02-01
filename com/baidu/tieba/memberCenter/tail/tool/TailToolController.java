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
    private View.OnClickListener lsF;
    private CustomMessageListener lsX;
    private g ltd;
    private h lti;
    private b ltj;
    private CustomMessageListener ltk;
    private Context mContext;

    public TailToolController(Context context) {
        super(context);
        this.acS = 0;
        this.lsX = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.mp(bool.booleanValue());
                }
            }
        };
        this.ltk = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.ltd.dgs()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.ltd.tZ(false);
                }
            }
        };
        this.lsF = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.dgn();
                TailToolController.this.dgm();
            }
        };
        init(context);
    }

    public TailToolController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acS = 0;
        this.lsX = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.mp(bool.booleanValue());
                }
            }
        };
        this.ltk = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.ltd.dgs()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.ltd.tZ(false);
                }
            }
        };
        this.lsF = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.dgn();
                TailToolController.this.dgm();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.lti = new h((ViewGroup) LayoutInflater.from(context).inflate(R.layout.tail_tool, (ViewGroup) this, true));
        this.ltd = new g(context);
        this.ltj = new b(context, this.ltd, this.lsF);
        this.lti.c(this.ltj);
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
    public void dgm() {
        hide();
        this.ltd.tZ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.mContext, this.ltd.getTails().isEmpty())));
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
        this.ltd.onAttached();
        MessageManager.getInstance().registerListener(this.lsX);
        MessageManager.getInstance().registerListener(this.ltk);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ltd.dgr();
        MessageManager.getInstance().unRegisterListener(this.lsX);
        MessageManager.getInstance().unRegisterListener(this.ltk);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        dgo();
    }

    private void dgo() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            mp(currentAccountObj.getIsSelectTail());
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
        this.ltd.dge();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
