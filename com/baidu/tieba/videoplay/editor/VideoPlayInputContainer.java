package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.s.c.t;
import d.b.h0.w.n;
import d.b.i0.k0.b;
import d.b.i0.u3.j;
import java.util.regex.Matcher;
/* loaded from: classes5.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f22002e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f22003f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22004g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22005h;
    public boolean i;
    public LinearLayout j;
    public View k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayInputContainer.this.d(new d.b.h0.w.a(1, 5, null));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable != null && editable.toString().trim() != null) {
                VideoPlayInputContainer videoPlayInputContainer = VideoPlayInputContainer.this;
                videoPlayInputContainer.d(new d.b.h0.w.a(4, -1, videoPlayInputContainer.f22003f.getText().toString()));
            }
            VideoPlayInputContainer.this.f22004g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
            VideoPlayInputContainer.this.k();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (VideoPlayInputContainer.this.n) {
                return;
            }
            VideoPlayInputContainer.this.n = true;
            if (VideoPlayInputContainer.this.o != -1) {
                VideoPlayInputContainer.this.f22003f.setSelection(VideoPlayInputContainer.this.o);
                VideoPlayInputContainer.this.o = -1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                VideoPlayInputContainer.this.d(new d.b.h0.w.a(5, -1, null));
                VideoPlayInputContainer.this.f22003f.requestFocus();
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayInputContainer.this.d(new d.b.h0.w.a(8, -1, null));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.f {
        public e() {
        }

        @Override // d.b.i0.k0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            VideoPlayInputContainer.this.f22003f.setText(spannableStringBuilder);
            VideoPlayInputContainer.this.f22003f.setSelection(VideoPlayInputContainer.this.f22003f.getText().length());
            VideoPlayInputContainer.this.d(new d.b.h0.w.a(5, -1, null));
            VideoPlayInputContainer.this.requestFocus();
        }
    }

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    @Override // d.b.h0.w.n
    public void b() {
        EditText editText = this.f22003f;
        if (editText != null) {
            editText.setFocusable(true);
            this.f22003f.setFocusableInTouchMode(true);
            this.f22003f.requestFocus();
            l.J(getContext(), this.f22003f);
        }
        setVisibility(0);
    }

    @Override // d.b.h0.w.n
    public void d(d.b.h0.w.a aVar) {
        EditorTools editorTools = this.f22002e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public EditText getInputView() {
        return this.f22003f;
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.l;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.h0.w.n
    public void init() {
    }

    public final void k() {
        if (this.f22004g.isEnabled()) {
            SkinManager.setViewTextColor(this.f22004g, R.color.CAM_X0302, 1, this.p);
        } else {
            SkinManager.setViewTextColor(this.f22004g, R.color.CAM_X0107, 1);
        }
    }

    public final void l(Context context) {
        ImageView imageView = new ImageView(context);
        this.f22005h = imageView;
        imageView.setEnabled(true);
        this.f22005h.setPadding(0, 0, l.g(context, R.dimen.tbds30), l.g(context, R.dimen.tbds24));
        this.f22005h.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.j.addView(this.f22005h, layoutParams);
    }

    public final void m(Context context) {
        EditText editText = new EditText(context);
        this.f22003f = editText;
        editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f22003f.setMaxLines(4);
        this.f22003f.setGravity(16);
        this.f22003f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f22003f.setBackgroundResource(R.color.common_color_10022);
        j.e(this.f22003f, R.drawable.edittext_cursor);
        this.f22003f.setPadding(0, l.g(context, R.dimen.ds24), l.g(context, R.dimen.ds54), l.g(context, R.dimen.ds24));
        this.f22003f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.f22003f.addTextChangedListener(new b());
        this.f22003f.setHint(context.getString(R.string.reply_something));
        this.f22003f.setOnTouchListener(new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.j.addView(this.f22003f, layoutParams);
    }

    public final void n(Context context) {
        TextView textView = new TextView(context);
        this.f22004g = textView;
        textView.setGravity(17);
        this.f22004g.setIncludeFontPadding(false);
        this.f22004g.setEnabled(false);
        this.f22004g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.f22004g.setText(R.string.send_replay);
        this.f22004g.setOnClickListener(new d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.g(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.j.addView(this.f22004g, layoutParams);
    }

    public final void o(t tVar) {
        if (!this.i || tVar.e() == EmotionGroupType.LOCAL) {
            String obj = this.f22003f.getText().toString();
            if (this.m && d.b.i0.k0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.b.i0.k0.b.b(getContext(), tVar, this.f22003f);
            }
        }
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
        Object obj;
        if (aVar == null) {
            return;
        }
        int i = aVar.f51523a;
        if (i == 3) {
            if (this.f22003f.getSelectionStart() > 0) {
                String substring = this.f22003f.getText().toString().substring(0, this.f22003f.getSelectionStart());
                Matcher matcher = d.b.i0.k0.a.f56419b.matcher(substring);
                if (matcher.find()) {
                    this.f22003f.getText().delete(this.f22003f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f22003f.getSelectionStart());
                } else {
                    this.f22003f.getText().delete(this.f22003f.getSelectionStart() - 1, this.f22003f.getSelectionStart());
                }
            }
        } else if (i == 6) {
            Object obj2 = aVar.f51525c;
            if (obj2 == null) {
                this.f22003f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f22003f.setText((CharSequence) null);
                } else {
                    d.b.i0.k0.b.d(getContext(), (String) aVar.f51525c, new e());
                }
            }
        } else if (i == 9) {
            if (((Boolean) aVar.f51525c).booleanValue()) {
                this.f22003f.setText((CharSequence) null);
            }
            this.f22004g.setEnabled(false);
            k();
        } else if (i == 24 && (obj = aVar.f51525c) != null && (obj instanceof t)) {
            t tVar = (t) obj;
            if (tVar.e() == EmotionGroupType.NET_SUG) {
                p(tVar);
            } else {
                o(tVar);
            }
        }
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
        this.p = i;
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f22003f, R.color.CAM_X0106, 2, i);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.e(this.f22003f, R.drawable.edittext_cursor);
            this.f22003f.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            j.e(this.f22003f, R.drawable.edittext_cursor_1);
            this.f22003f.setHintTextColor(SkinManager.getColor(i, R.color.CAM_X0109));
        }
        k();
        SkinManager.setImageResource(this.f22005h, R.drawable.pbeditor_face_button);
    }

    public final void p(t tVar) {
        if (tVar == null || TextUtils.isEmpty(tVar.b()) || TextUtils.isEmpty(tVar.f())) {
            return;
        }
        String obj = this.f22003f.getText().toString();
        if (this.m && d.b.i0.k0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.b.i0.k0.b.c(getContext(), tVar, this.f22003f);
        }
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f22002e = editorTools;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.l = i;
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        this.m = true;
        this.n = true;
        this.o = -1;
        this.p = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.j = linearLayout;
        linearLayout.setOrientation(0);
        this.j.setMinimumHeight(l.g(context, R.dimen.ds90));
        addView(this.j, new LinearLayout.LayoutParams(-1, -2));
        l(context);
        m(context);
        n(context);
        this.k = new View(getContext());
        this.k.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.k);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
