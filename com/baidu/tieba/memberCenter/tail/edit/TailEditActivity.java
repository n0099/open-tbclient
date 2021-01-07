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
    private a lox;
    private b loy;
    com.baidu.tieba.memberCenter.tail.a.a<Integer> loz = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(true, z, str, num);
        }
    };
    com.baidu.tieba.memberCenter.tail.a.a<Integer> loA = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(false, z, str, num);
        }
    };
    private View.OnClickListener loB = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TailEditActivity.this.loy.getEditText().length() != 0) {
                TailEditActivity.this.loy.showProgressBar();
                TailEditActivity.this.lox.OB(TailEditActivity.this.loy.getEditText().getText().toString());
                return;
            }
            TailEditActivity.this.showToast(TailEditActivity.this.getResources().getString(R.string.tail_submit_empty_toast));
        }
    };
    private View.OnClickListener loC = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailEditActivity.this.lox.dhL().setContent(TailEditActivity.this.loy.getContent());
            if (TailEditActivity.this.lox.dhJ()) {
                TailEditActivity.this.dhI();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            TailEditActivity.this.finish();
        }
    };
    private View.OnTouchListener loD = new View.OnTouchListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                TailEditActivity.this.loy.bDf();
                return false;
            }
            return false;
        }
    };
    private TextWatcher loE = new TextWatcher() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.6
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TailEditActivity.this.Oz(charSequence.toString());
        }
    };
    private com.baidu.tbadk.editortools.b loF = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.7
        @Override // com.baidu.tbadk.editortools.b
        public void a(com.baidu.tbadk.editortools.a aVar) {
            if (aVar != null) {
                if (aVar.code == 24) {
                    TailEditActivity.this.aP(aVar.data);
                } else if (aVar.code == 26) {
                    TailEditActivity.this.aO(aVar.data);
                } else if (aVar.code == 3) {
                    TailEditActivity.this.loy.dhN();
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
        this.loy = new b(this, this.loB, this.loC);
        this.lox = new a(getPageContext());
        initListener();
        dhG();
        dbR();
        this.loy.dhO();
        adjustResizeForSoftInput(R.color.common_color_10022, true);
    }

    private void initListener() {
        this.lox.a(this.loz);
        this.lox.b(this.loA);
        this.loy.getEditText().addTextChangedListener(this.loE);
        this.loy.getEditText().setOnTouchListener(this.loD);
    }

    private void dhG() {
        this.lox.b(getIntent().getIntExtra(TailEditActivityConfig.TAIL_ID, 0), getIntent().getStringExtra(TailEditActivityConfig.TAIL_CONTENT), getIntent().getStringExtra(TailEditActivityConfig.TAIL_COLOR), getIntent().getBooleanExtra(TailEditActivityConfig.IS_NO_TAIL, false));
        this.loy.a(this.lox.dhL());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        dhH();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        dhH();
    }

    private void dhH() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, String str, Integer num) {
        this.loy.hideProgressBar();
        if (z2) {
            showToast(str);
        } else if (num != null) {
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            tailData.setContent(this.lox.dhL().getContent());
            tailData.setFontColor(this.lox.dhK());
            e eVar = new e(1, tailData);
            if (!z) {
                eVar.lou = 2;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            finish();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oz(String str) {
        String OA = OA(str);
        this.lox.dhL().setContent(OA);
        this.loy.cW(this.lox.OD(OA), 50);
        this.loy.tM(this.lox.dhM());
    }

    private String OA(String str) {
        if (this.lox.FT(this.lox.OD(str))) {
            String OE = this.lox.OE(str);
            this.loy.setContent(OE);
            this.loy.dhP();
            return OE;
        }
        return str;
    }

    private void dbR() {
        this.loy.a(this.loF, this.lox.dhK());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(Object obj) {
        if (obj != null) {
            String obj2 = obj.toString();
            this.loy.setColor(obj2);
            this.lox.OC(obj2);
            this.loy.tM(this.lox.dhM());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(Object obj) {
        this.lox.dhL().setContent(this.loy.getContent());
        if (this.lox.FS(this.lox.OD(this.lox.dhL().getContent()))) {
            showToast(R.string.over_limit_tip);
        } else if (obj != null && (obj instanceof u)) {
            new com.baidu.tieba.memberCenter.tail.a.b().a(this, this.loy.getEditText(), (u) obj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.lox.dhL().setContent(this.loy.getContent());
            if (this.lox.dhJ()) {
                dhI();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhI() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.Bo(getResources().getString(R.string.tail_cancel_modified_toast));
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
        aVar.btY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.loy.onChangeSkinType(i);
    }
}
