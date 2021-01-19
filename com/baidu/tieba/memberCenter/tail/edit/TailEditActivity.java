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
/* loaded from: classes8.dex */
public class TailEditActivity extends BaseActivity<TailEditActivity> {
    private a ljN;
    private b ljO;
    com.baidu.tieba.memberCenter.tail.a.a<Integer> ljP = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(true, z, str, num);
        }
    };
    com.baidu.tieba.memberCenter.tail.a.a<Integer> ljQ = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(false, z, str, num);
        }
    };
    private View.OnClickListener ljR = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TailEditActivity.this.ljO.getEditText().length() != 0) {
                TailEditActivity.this.ljO.showProgressBar();
                TailEditActivity.this.ljN.Nu(TailEditActivity.this.ljO.getEditText().getText().toString());
                return;
            }
            TailEditActivity.this.showToast(TailEditActivity.this.getResources().getString(R.string.tail_submit_empty_toast));
        }
    };
    private View.OnClickListener ljS = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailEditActivity.this.ljN.ddT().setContent(TailEditActivity.this.ljO.getContent());
            if (TailEditActivity.this.ljN.ddR()) {
                TailEditActivity.this.ddQ();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            TailEditActivity.this.finish();
        }
    };
    private View.OnTouchListener ljT = new View.OnTouchListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                TailEditActivity.this.ljO.bzl();
                return false;
            }
            return false;
        }
    };
    private TextWatcher ljU = new TextWatcher() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.6
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TailEditActivity.this.Ns(charSequence.toString());
        }
    };
    private com.baidu.tbadk.editortools.b ljV = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.7
        @Override // com.baidu.tbadk.editortools.b
        public void a(com.baidu.tbadk.editortools.a aVar) {
            if (aVar != null) {
                if (aVar.code == 24) {
                    TailEditActivity.this.aP(aVar.data);
                } else if (aVar.code == 26) {
                    TailEditActivity.this.aO(aVar.data);
                } else if (aVar.code == 3) {
                    TailEditActivity.this.ljO.ddV();
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
        this.ljO = new b(this, this.ljR, this.ljS);
        this.ljN = new a(getPageContext());
        initListener();
        ddO();
        cXZ();
        this.ljO.ddW();
        adjustResizeForSoftInput(R.color.common_color_10022, true);
    }

    private void initListener() {
        this.ljN.a(this.ljP);
        this.ljN.b(this.ljQ);
        this.ljO.getEditText().addTextChangedListener(this.ljU);
        this.ljO.getEditText().setOnTouchListener(this.ljT);
    }

    private void ddO() {
        this.ljN.b(getIntent().getIntExtra(TailEditActivityConfig.TAIL_ID, 0), getIntent().getStringExtra(TailEditActivityConfig.TAIL_CONTENT), getIntent().getStringExtra(TailEditActivityConfig.TAIL_COLOR), getIntent().getBooleanExtra(TailEditActivityConfig.IS_NO_TAIL, false));
        this.ljO.a(this.ljN.ddT());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ddP();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ddP();
    }

    private void ddP() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, String str, Integer num) {
        this.ljO.hideProgressBar();
        if (z2) {
            showToast(str);
        } else if (num != null) {
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            tailData.setContent(this.ljN.ddT().getContent());
            tailData.setFontColor(this.ljN.ddS());
            e eVar = new e(1, tailData);
            if (!z) {
                eVar.ljL = 2;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            finish();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns(String str) {
        String Nt = Nt(str);
        this.ljN.ddT().setContent(Nt);
        this.ljO.cW(this.ljN.Nw(Nt), 50);
        this.ljO.tI(this.ljN.ddU());
    }

    private String Nt(String str) {
        if (this.ljN.En(this.ljN.Nw(str))) {
            String Nx = this.ljN.Nx(str);
            this.ljO.setContent(Nx);
            this.ljO.ddX();
            return Nx;
        }
        return str;
    }

    private void cXZ() {
        this.ljO.a(this.ljV, this.ljN.ddS());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(Object obj) {
        if (obj != null) {
            String obj2 = obj.toString();
            this.ljO.setColor(obj2);
            this.ljN.Nv(obj2);
            this.ljO.tI(this.ljN.ddU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(Object obj) {
        this.ljN.ddT().setContent(this.ljO.getContent());
        if (this.ljN.Em(this.ljN.Nw(this.ljN.ddT().getContent()))) {
            showToast(R.string.over_limit_tip);
        } else if (obj != null && (obj instanceof u)) {
            new com.baidu.tieba.memberCenter.tail.a.b().a(this, this.ljO.getEditText(), (u) obj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.ljN.ddT().setContent(this.ljO.getContent());
            if (this.ljN.ddR()) {
                ddQ();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddQ() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.Ad(getResources().getString(R.string.tail_cancel_modified_toast));
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
        aVar.bqe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ljO.onChangeSkinType(i);
    }
}
