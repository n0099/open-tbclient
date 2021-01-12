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
    private EditorTools acX;
    private int acY;
    private CustomMessageListener lkR;
    private g lkX;
    private View.OnClickListener lkz;
    private h llc;
    private b lld;
    private CustomMessageListener lle;
    private Context mContext;

    public TailToolController(Context context) {
        super(context);
        this.acY = 0;
        this.lkR = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.ml(bool.booleanValue());
                }
            }
        };
        this.lle = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.lkX.des()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.lkX.tM(false);
                }
            }
        };
        this.lkz = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.den();
                TailToolController.this.dem();
            }
        };
        init(context);
    }

    public TailToolController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acY = 0;
        this.lkR = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_TOOL_RED_DOT) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Boolean bool;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null) {
                    TailToolController.this.ml(bool.booleanValue());
                }
            }
        };
        this.lle = new CustomMessageListener(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE) { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && TailToolController.this.lkX.des()) {
                    TailToolController.this.setVisibility(0);
                    TailToolController.this.lkX.tM(false);
                }
            }
        };
        this.lkz = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.tool.TailToolController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TailToolController.this.den();
                TailToolController.this.dem();
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.llc = new h((ViewGroup) LayoutInflater.from(context).inflate(R.layout.tail_tool, (ViewGroup) this, true));
        this.lkX = new g(context);
        this.lld = new b(context, this.lkX, this.lkz);
        this.llc.c(this.lld);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml(boolean z) {
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
    public void dem() {
        hide();
        this.lkX.tM(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void den() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailEditActivityConfig(this.mContext, this.lkX.getTails().isEmpty())));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.lkX.onAttached();
        MessageManager.getInstance().registerListener(this.lkR);
        MessageManager.getInstance().registerListener(this.lle);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lkX.der();
        MessageManager.getInstance().unRegisterListener(this.lkR);
        MessageManager.getInstance().unRegisterListener(this.lle);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        deo();
    }

    private void deo() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ml(currentAccountObj.getIsSelectTail());
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        setVisibility(0);
        this.lkX.dee();
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
