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
    private EditorTools acZ;
    private int ada;
    private CustomMessageListener lpB;
    private g lpH;
    private h lpM;
    private b lpN;
    private CustomMessageListener lpO;
    private View.OnClickListener lpj;
    private Context mContext;

    public TailToolController(Context context) {
        super(context);
        this.ada = 0;
        this.lpB = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.mp(bool.booleanValue());
                }
            }
        };
        this.lpO = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.lpH.dik()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.lpH.tQ(false);
                }
            }
        };
        this.lpj = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.dif();
                TailToolController.this.die();
            }
        };
        init(context);
    }

    public TailToolController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ada = 0;
        this.lpB = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.mp(bool.booleanValue());
                }
            }
        };
        this.lpO = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.lpH.dik()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.lpH.tQ(false);
                }
            }
        };
        this.lpj = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.dif();
                TailToolController.this.die();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.lpM = new h((ViewGroup) LayoutInflater.from(context).inflate(R.layout.tail_tool, (ViewGroup) this, true));
        this.lpH = new g(context);
        this.lpN = new b(context, this.lpH, this.lpj);
        this.lpM.c(this.lpN);
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
    public void die() {
        hide();
        this.lpH.tQ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dif() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.mContext, this.lpH.getTails().isEmpty())));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.lpH.onAttached();
        MessageManager.getInstance().registerListener(this.lpB);
        MessageManager.getInstance().registerListener(this.lpO);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lpH.dij();
        MessageManager.getInstance().unRegisterListener(this.lpB);
        MessageManager.getInstance().unRegisterListener(this.lpO);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        dig();
    }

    private void dig() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            mp(currentAccountObj.getIsSelectTail());
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        setVisibility(0);
        this.lpH.dhW();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
