package com.baidu.tieba.memberCenter.tail.edit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.tieba.memberCenter.tail.data.e;
/* loaded from: classes9.dex */
public class TailEditActivity extends BaseActivity<TailEditActivity> {
    private a lrT;
    private b lrU;
    com.baidu.tieba.memberCenter.tail.a.a<Integer> lrV = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(true, z, str, num);
        }
    };
    com.baidu.tieba.memberCenter.tail.a.a<Integer> lrW = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(false, z, str, num);
        }
    };
    private View.OnClickListener lrX = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TailEditActivity.this.lrU.getEditText().length() != 0) {
                TailEditActivity.this.lrU.showProgressBar();
                TailEditActivity.this.lrT.Oi(TailEditActivity.this.lrU.getEditText().getText().toString());
                return;
            }
            TailEditActivity.this.showToast(TailEditActivity.this.getResources().getString(R.string.tail_submit_empty_toast));
        }
    };
    private View.OnClickListener lrY = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailEditActivity.this.lrT.dfT().setContent(TailEditActivity.this.lrU.getContent());
            if (TailEditActivity.this.lrT.dfR()) {
                TailEditActivity.this.dfQ();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            TailEditActivity.this.finish();
        }
    };
    private View.OnTouchListener lrZ = new View.OnTouchListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                TailEditActivity.this.lrU.bzD();
                return false;
            }
            return false;
        }
    };
    private TextWatcher lsa = new TextWatcher() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.6
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TailEditActivity.this.Og(charSequence.toString());
        }
    };
    private com.baidu.tbadk.editortools.b lsb = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.7
        @Override // com.baidu.tbadk.editortools.b
        public void a(com.baidu.tbadk.editortools.a aVar) {
            if (aVar != null) {
                if (aVar.code == 24) {
                    TailEditActivity.this.aP(aVar.data);
                } else if (aVar.code == 26) {
                    TailEditActivity.this.aO(aVar.data);
                } else if (aVar.code == 3) {
                    TailEditActivity.this.lrU.dfV();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tail_edit_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.lrU = new b(this, this.lrX, this.lrY);
        this.lrT = new a(getPageContext());
        initListener();
        dfO();
        cZX();
        this.lrU.dfW();
        adjustResizeForSoftInput(R.color.common_color_10022, true);
    }

    private void initListener() {
        this.lrT.a(this.lrV);
        this.lrT.b(this.lrW);
        this.lrU.getEditText().addTextChangedListener(this.lsa);
        this.lrU.getEditText().setOnTouchListener(this.lrZ);
    }

    private void dfO() {
        this.lrT.b(getIntent().getIntExtra(TailEditActivityConfig.TAIL_ID, 0), getIntent().getStringExtra(TailEditActivityConfig.TAIL_CONTENT), getIntent().getStringExtra(TailEditActivityConfig.TAIL_COLOR), getIntent().getBooleanExtra(TailEditActivityConfig.IS_NO_TAIL, false));
        this.lrU.a(this.lrT.dfT());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        dfP();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        dfP();
    }

    private void dfP() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, String str, Integer num) {
        this.lrU.hideProgressBar();
        if (z2) {
            showToast(str);
        } else if (num != null) {
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            tailData.setContent(this.lrT.dfT().getContent());
            tailData.setFontColor(this.lrT.dfS());
            e eVar = new e(1, tailData);
            if (!z) {
                eVar.lrR = 2;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            finish();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(String str) {
        String Oh = Oh(str);
        this.lrT.dfT().setContent(Oh);
        this.lrU.cT(this.lrT.Ok(Oh), 50);
        this.lrU.tV(this.lrT.dfU());
    }

    private String Oh(String str) {
        if (this.lrT.EF(this.lrT.Ok(str))) {
            String Ol = this.lrT.Ol(str);
            this.lrU.setContent(Ol);
            this.lrU.dfX();
            return Ol;
        }
        return str;
    }

    private void cZX() {
        this.lrU.a(this.lsb, this.lrT.dfS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(Object obj) {
        if (obj != null) {
            String obj2 = obj.toString();
            this.lrU.setColor(obj2);
            this.lrT.Oj(obj2);
            this.lrU.tV(this.lrT.dfU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(Object obj) {
        this.lrT.dfT().setContent(this.lrU.getContent());
        if (this.lrT.EE(this.lrT.Ok(this.lrT.dfT().getContent()))) {
            showToast(R.string.over_limit_tip);
        } else if (obj != null && (obj instanceof u)) {
            new com.baidu.tieba.memberCenter.tail.a.b().a(this, this.lrU.getEditText(), (u) obj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.lrT.dfT().setContent(this.lrU.getContent());
            if (this.lrT.dfR()) {
                dfQ();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfQ() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.Au(getResources().getString(R.string.tail_cancel_modified_toast));
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
                TailEditActivity.this.finish();
            }
        });
        aVar.b(getPageContext());
        aVar.bqx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.lrU.onChangeSkinType(i);
    }
}
