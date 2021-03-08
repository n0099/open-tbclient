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
    private a luk;
    private b lul;
    com.baidu.tieba.memberCenter.tail.a.a<Integer> lum = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(true, z, str, num);
        }
    };
    com.baidu.tieba.memberCenter.tail.a.a<Integer> lun = new com.baidu.tieba.memberCenter.tail.a.a<Integer>() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.memberCenter.tail.a.a
        /* renamed from: a */
        public void b(boolean z, String str, Integer num) {
            TailEditActivity.this.a(false, z, str, num);
        }
    };
    private View.OnClickListener luo = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TailEditActivity.this.lul.getEditText().length() != 0) {
                TailEditActivity.this.lul.showProgressBar();
                TailEditActivity.this.luk.Op(TailEditActivity.this.lul.getEditText().getText().toString());
                return;
            }
            TailEditActivity.this.showToast(TailEditActivity.this.getResources().getString(R.string.tail_submit_empty_toast));
        }
    };
    private View.OnClickListener lup = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailEditActivity.this.luk.dgj().setContent(TailEditActivity.this.lul.getContent());
            if (TailEditActivity.this.luk.dgh()) {
                TailEditActivity.this.dgg();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            TailEditActivity.this.finish();
        }
    };
    private View.OnTouchListener luq = new View.OnTouchListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                TailEditActivity.this.lul.bzG();
                return false;
            }
            return false;
        }
    };
    private TextWatcher lur = new TextWatcher() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.6
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TailEditActivity.this.On(charSequence.toString());
        }
    };
    private com.baidu.tbadk.editortools.b lus = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.memberCenter.tail.edit.TailEditActivity.7
        @Override // com.baidu.tbadk.editortools.b
        public void a(com.baidu.tbadk.editortools.a aVar) {
            if (aVar != null) {
                if (aVar.code == 24) {
                    TailEditActivity.this.aR(aVar.data);
                } else if (aVar.code == 26) {
                    TailEditActivity.this.aQ(aVar.data);
                } else if (aVar.code == 3) {
                    TailEditActivity.this.lul.dgl();
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
        this.lul = new b(this, this.luo, this.lup);
        this.luk = new a(getPageContext());
        initListener();
        dge();
        dan();
        this.lul.dgm();
        adjustResizeForSoftInput(R.color.common_color_10022, true);
    }

    private void initListener() {
        this.luk.a(this.lum);
        this.luk.b(this.lun);
        this.lul.getEditText().addTextChangedListener(this.lur);
        this.lul.getEditText().setOnTouchListener(this.luq);
    }

    private void dge() {
        this.luk.b(getIntent().getIntExtra(TailEditActivityConfig.TAIL_ID, 0), getIntent().getStringExtra(TailEditActivityConfig.TAIL_CONTENT), getIntent().getStringExtra(TailEditActivityConfig.TAIL_COLOR), getIntent().getBooleanExtra(TailEditActivityConfig.IS_NO_TAIL, false));
        this.lul.a(this.luk.dgj());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        dgf();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        dgf();
    }

    private void dgf() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, String str, Integer num) {
        this.lul.hideProgressBar();
        if (z2) {
            showToast(str);
        } else if (num != null) {
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            tailData.setContent(this.luk.dgj().getContent());
            tailData.setFontColor(this.luk.dgi());
            e eVar = new e(1, tailData);
            if (!z) {
                eVar.lui = 2;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_EDIT_CLOSE, null));
            finish();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TAIL_REFRESH, eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void On(String str) {
        String Oo = Oo(str);
        this.luk.dgj().setContent(Oo);
        this.lul.cU(this.luk.Or(Oo), 50);
        this.lul.tV(this.luk.dgk());
    }

    private String Oo(String str) {
        if (this.luk.EI(this.luk.Or(str))) {
            String Os = this.luk.Os(str);
            this.lul.setContent(Os);
            this.lul.dgn();
            return Os;
        }
        return str;
    }

    private void dan() {
        this.lul.a(this.lus, this.luk.dgi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(Object obj) {
        if (obj != null) {
            String obj2 = obj.toString();
            this.lul.setColor(obj2);
            this.luk.Oq(obj2);
            this.lul.tV(this.luk.dgk());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(Object obj) {
        this.luk.dgj().setContent(this.lul.getContent());
        if (this.luk.EH(this.luk.Or(this.luk.dgj().getContent()))) {
            showToast(R.string.over_limit_tip);
        } else if (obj != null && (obj instanceof u)) {
            new com.baidu.tieba.memberCenter.tail.a.b().a(this, this.lul.getEditText(), (u) obj);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.luk.dgj().setContent(this.lul.getContent());
            if (this.luk.dgh()) {
                dgg();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgg() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.AB(getResources().getString(R.string.tail_cancel_modified_toast));
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
        aVar.bqz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.lul.onChangeSkinType(i);
    }
}
