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
/* loaded from: classes8.dex */
public class TailToolController extends NoPressedLinearLayout implements n {
    private EditorTools ael;
    private int aem;
    private View.OnClickListener luW;
    private b lvA;
    private CustomMessageListener lvB;
    private CustomMessageListener lvo;
    private g lvu;
    private h lvz;
    private Context mContext;

    public TailToolController(Context context) {
        super(context);
        this.aem = 0;
        this.lvo = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.mp(bool.booleanValue());
                }
            }
        };
        this.lvB = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.lvu.dgI()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.lvu.tZ(false);
                }
            }
        };
        this.luW = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.dgD();
                TailToolController.this.dgC();
            }
        };
        init(context);
    }

    public TailToolController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aem = 0;
        this.lvo = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.mp(bool.booleanValue());
                }
            }
        };
        this.lvB = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.lvu.dgI()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.lvu.tZ(false);
                }
            }
        };
        this.luW = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.dgD();
                TailToolController.this.dgC();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.lvz = new h((ViewGroup) LayoutInflater.from(context).inflate(R.layout.tail_tool, (ViewGroup) this, true));
        this.lvu = new g(context);
        this.lvA = new b(context, this.lvu, this.luW);
        this.lvz.c(this.lvA);
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
    public void dgC() {
        hide();
        this.lvu.tZ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgD() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.mContext, this.lvu.getTails().isEmpty())));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aem = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.lvu.onAttached();
        MessageManager.getInstance().registerListener(this.lvo);
        MessageManager.getInstance().registerListener(this.lvB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lvu.dgH();
        MessageManager.getInstance().unRegisterListener(this.lvo);
        MessageManager.getInstance().unRegisterListener(this.lvB);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aem;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        dgE();
    }

    private void dgE() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            mp(currentAccountObj.getIsSelectTail());
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
        this.lvu.dgu();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
