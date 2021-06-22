package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.R;
import d.a.n0.s.c.v;
import d.a.o0.l0.b;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PbFullScreenEditorInputView extends SpanGroupEditText {

    /* loaded from: classes5.dex */
    public class a implements b.f {
        public a() {
        }

        @Override // d.a.o0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbFullScreenEditorInputView.this.setText(spannableStringBuilder);
            PbFullScreenEditorInputView pbFullScreenEditorInputView = PbFullScreenEditorInputView.this;
            pbFullScreenEditorInputView.setSelection(pbFullScreenEditorInputView.getText().length());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.f {
        public b() {
        }

        @Override // d.a.o0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbFullScreenEditorInputView.this.setHint(spannableStringBuilder);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements b.f {
        public c() {
        }

        @Override // d.a.o0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbFullScreenEditorInputView.this.setText(spannableStringBuilder);
            PbFullScreenEditorInputView pbFullScreenEditorInputView = PbFullScreenEditorInputView.this;
            pbFullScreenEditorInputView.setSelection(pbFullScreenEditorInputView.getText().length());
        }
    }

    public PbFullScreenEditorInputView(Context context) {
        super(context);
        i();
    }

    public void g(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append("@");
            sb.append(arrayList.get(i2));
            sb.append(" ");
        }
        String sb2 = sb.toString();
        getText().insert(getSelectionStart(), sb2);
    }

    public void h(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public final void i() {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.o0.l0.b.d(getContext(), str, new a());
    }

    public void k(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            d.a.o0.l0.b.d(getContext(), str, new b());
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        d.a.o0.l0.b.d(getContext(), str2, new c());
    }

    public void l(v vVar) {
        if (d.a.o0.l0.a.a(getText().toString()) >= 10) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.a.o0.l0.b.b(getContext(), vVar, this);
        }
    }

    public PbFullScreenEditorInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    public PbFullScreenEditorInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        i();
    }
}
