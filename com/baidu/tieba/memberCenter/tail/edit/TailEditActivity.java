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
    private a lsh;
    private b lsi;
    com.baidu.tieba.memberCenter.tail.a.a<Integer> lsj = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(true, z, str, num);
        }
    };
    com.baidu.tieba.memberCenter.tail.a.a<Integer> lsk = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(false, z, str, num);
        }
    };
    private View.OnClickListener lsl = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TailEditActivity.this.lsi.getEditText().length() != 0) {
                TailEditActivity.this.lsi.showProgressBar();
                TailEditActivity.this.lsh.Oj(TailEditActivity.this.lsi.getEditText().getText().toString());
                return;
            }
            TailEditActivity.this.showToast(TailEditActivity.this.getResources().getString(R.string.tail_submit_empty_toast));
        }
    };
    private View.OnClickListener lsm = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailEditActivity.this.lsh.dga().setContent(TailEditActivity.this.lsi.getContent());
            if (TailEditActivity.this.lsh.dfY()) {
                TailEditActivity.this.dfX();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            TailEditActivity.this.finish();
        }
    };
    private View.OnTouchListener lsn = new View.OnTouchListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                TailEditActivity.this.lsi.bzD();
                return false;
            }
            return false;
        }
    };
    private TextWatcher lso = new TextWatcher() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.6
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TailEditActivity.this.Oh(charSequence.toString());
        }
    };
    private com.baidu.tbadk.editortools.b lsp = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.7
        @Override // com.baidu.tbadk.editortools.b
        public void a(com.baidu.tbadk.editortools.a aVar) {
            if (aVar != null) {
                if (aVar.code == 24) {
                    TailEditActivity.this.aP(aVar.data);
                } else if (aVar.code == 26) {
                    TailEditActivity.this.aO(aVar.data);
                } else if (aVar.code == 3) {
                    TailEditActivity.this.lsi.dgc();
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
        this.lsi = new b(this, this.lsl, this.lsm);
        this.lsh = new a(getPageContext());
        initListener();
        dfV();
        dae();
        this.lsi.dgd();
        adjustResizeForSoftInput(R.color.common_color_10022, true);
    }

    private void initListener() {
        this.lsh.a(this.lsj);
        this.lsh.b(this.lsk);
        this.lsi.getEditText().addTextChangedListener(this.lso);
        this.lsi.getEditText().setOnTouchListener(this.lsn);
    }

    private void dfV() {
        this.lsh.b(getIntent().getIntExtra(TailEditActivityConfig.TAIL_ID, 0), getIntent().getStringExtra(TailEditActivityConfig.TAIL_CONTENT), getIntent().getStringExtra(TailEditActivityConfig.TAIL_COLOR), getIntent().getBooleanExtra(TailEditActivityConfig.IS_NO_TAIL, false));
        this.lsi.a(this.lsh.dga());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        dfW();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        dfW();
    }

    private void dfW() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, String str, Integer num) {
        this.lsi.hideProgressBar();
        if (z2) {
            showToast(str);
        } else if (num != null) {
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            tailData.setContent(this.lsh.dga().getContent());
            tailData.setFontColor(this.lsh.dfZ());
            e eVar = new e(1, tailData);
            if (!z) {
                eVar.lsf = 2;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            finish();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(String str) {
        String Oi = Oi(str);
        this.lsh.dga().setContent(Oi);
        this.lsi.cU(this.lsh.Ol(Oi), 50);
        this.lsi.tV(this.lsh.dgb());
    }

    private String Oi(String str) {
        if (this.lsh.EF(this.lsh.Ol(str))) {
            String Om = this.lsh.Om(str);
            this.lsi.setContent(Om);
            this.lsi.dge();
            return Om;
        }
        return str;
    }

    private void dae() {
        this.lsi.a(this.lsp, this.lsh.dfZ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(Object obj) {
        if (obj != null) {
            String obj2 = obj.toString();
            this.lsi.setColor(obj2);
            this.lsh.Ok(obj2);
            this.lsi.tV(this.lsh.dgb());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(Object obj) {
        this.lsh.dga().setContent(this.lsi.getContent());
        if (this.lsh.EE(this.lsh.Ol(this.lsh.dga().getContent()))) {
            showToast(R.string.over_limit_tip);
        } else if (obj != null && (obj instanceof u)) {
            new com.baidu.tieba.memberCenter.tail.a.b().a(this, this.lsi.getEditText(), (u) obj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.lsh.dga().setContent(this.lsi.getContent());
            if (this.lsh.dfY()) {
                dfX();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfX() {
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
        this.lsi.onChangeSkinType(i);
    }
}
