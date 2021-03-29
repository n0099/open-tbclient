package com.baidu.tieba.memberCenter.tail.edit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import d.b.h0.r.s.a;
import d.b.h0.s.c.t;
/* loaded from: classes3.dex */
public class TailEditActivity extends BaseActivity<TailEditActivity> {
    public d.b.i0.q1.h.b.a mModel;
    public d.b.i0.q1.h.b.b mView;
    public d.b.i0.q1.h.f.a<Integer> addTailCallBack = new a();
    public d.b.i0.q1.h.f.a<Integer> updateTailCallBack = new b();
    public View.OnClickListener mSubmitButtonClickListener = new c();
    public View.OnClickListener mCancelButtonClickListener = new d();
    public View.OnTouchListener mTextOnTouchListener = new e();
    public TextWatcher mTextNumberWatcher = new f();
    public d.b.h0.w.b mEditorListener = new g();

    /* loaded from: classes3.dex */
    public class a implements d.b.i0.q1.h.f.a<Integer> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.q1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            TailEditActivity.this.submitCallback(true, z, str, num);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.i0.q1.h.f.a<Integer> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.q1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            TailEditActivity.this.submitCallback(false, z, str, num);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TailEditActivity.this.mView.h().length() != 0) {
                TailEditActivity.this.mView.r();
                TailEditActivity.this.mModel.r(TailEditActivity.this.mView.h().getText().toString());
                return;
            }
            TailEditActivity tailEditActivity = TailEditActivity.this;
            tailEditActivity.showToast(tailEditActivity.getResources().getString(R.string.tail_submit_empty_toast));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailEditActivity.this.mModel.i().setContent(TailEditActivity.this.mView.g());
            if (TailEditActivity.this.mModel.k()) {
                TailEditActivity.this.confirmCancelEdit();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
            TailEditActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                TailEditActivity.this.mView.j();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TailEditActivity.this.userInputChanged(charSequence.toString());
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.h0.w.b {
        public g() {
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            if (aVar == null) {
                return;
            }
            int i = aVar.f51524a;
            if (i == 24) {
                TailEditActivity.this.addEmotion(aVar.f51526c);
            } else if (i == 26) {
                TailEditActivity.this.changeColor(aVar.f51526c);
            } else if (i == 3) {
                TailEditActivity.this.mView.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f19003e;

        public h(d.b.h0.r.s.a aVar) {
            this.f19003e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f19003e.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f19005e;

        public i(d.b.h0.r.s.a aVar) {
            this.f19005e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f19005e.dismiss();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
            TailEditActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEmotion(Object obj) {
        this.mModel.i().setContent(this.mView.g());
        d.b.i0.q1.h.b.a aVar = this.mModel;
        if (aVar.l(aVar.e(aVar.i().getContent()))) {
            showToast(R.string.over_limit_tip);
        } else if (obj == null || !(obj instanceof t)) {
        } else {
            new d.b.i0.q1.h.f.b().b(this, this.mView.h(), (t) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeColor(Object obj) {
        if (obj == null) {
            return;
        }
        String obj2 = obj.toString();
        this.mView.m(obj2);
        this.mModel.o(obj2);
        this.mView.p(this.mModel.s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmCancelEdit() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getActivity());
        aVar.setMessage(getResources().getString(R.string.tail_cancel_modified_toast));
        aVar.setNegativeButton(R.string.cancel, new h(aVar));
        aVar.setPositiveButton(R.string.confirm, new i(aVar));
        aVar.create(getPageContext());
        aVar.show();
    }

    private String cutTextToMax(String str) {
        if (this.mModel.m(this.mModel.e(str))) {
            String h2 = this.mModel.h(str);
            this.mView.n(h2);
            this.mView.k();
            return h2;
        }
        return str;
    }

    private void initEditor() {
        this.mView.a(this.mEditorListener, this.mModel.g());
    }

    private void initListener() {
        this.mModel.n(this.addTailCallBack);
        this.mModel.q(this.updateTailCallBack);
        this.mView.h().addTextChangedListener(this.mTextNumberWatcher);
        this.mView.h().setOnTouchListener(this.mTextOnTouchListener);
    }

    private void loadTailData() {
        this.mModel.j(getIntent().getIntExtra(TailEditActivityConfig.TAIL_ID, 0), getIntent().getStringExtra(TailEditActivityConfig.TAIL_CONTENT), getIntent().getStringExtra(TailEditActivityConfig.TAIL_COLOR), getIntent().getBooleanExtra(TailEditActivityConfig.IS_NO_TAIL, false));
        this.mView.s(this.mModel.i());
    }

    private void setAnimation() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitCallback(boolean z, boolean z2, String str, Integer num) {
        this.mView.i();
        if (z2) {
            showToast(str);
        } else if (num == null) {
        } else {
            TailData tailData = new TailData();
            tailData.setId(num.intValue());
            tailData.setContent(this.mModel.i().getContent());
            tailData.setFontColor(this.mModel.g());
            d.b.i0.q1.h.a.e eVar = new d.b.i0.q1.h.a.e(1, tailData);
            if (!z) {
                eVar.f59487a = 2;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
            finish();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void userInputChanged(String str) {
        String cutTextToMax = cutTextToMax(str);
        this.mModel.i().setContent(cutTextToMax);
        this.mView.q(this.mModel.e(cutTextToMax), 50);
        this.mView.p(this.mModel.s());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        setAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        setAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        this.mView.l(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tail_edit_activity);
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        this.mView = new d.b.i0.q1.h.b.b(this, this.mSubmitButtonClickListener, this.mCancelButtonClickListener);
        this.mModel = new d.b.i0.q1.h.b.a(getPageContext());
        initListener();
        loadTailData();
        initEditor();
        this.mView.f();
        adjustResizeForSoftInput(R.color.common_color_10022, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.mModel.i().setContent(this.mView.g());
            if (this.mModel.k()) {
                confirmCancelEdit();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
