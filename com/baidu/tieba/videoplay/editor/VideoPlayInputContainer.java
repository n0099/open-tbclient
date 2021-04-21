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
import d.b.c.e.p.l;
import d.b.i0.s.c.v;
import d.b.i0.w.n;
import d.b.j0.k0.b;
import d.b.j0.v3.j;
import java.util.regex.Matcher;
/* loaded from: classes5.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f21696e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f21697f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21698g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21699h;
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
            VideoPlayInputContainer.this.d(new d.b.i0.w.a(1, 5, null));
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
                videoPlayInputContainer.d(new d.b.i0.w.a(4, -1, videoPlayInputContainer.f21697f.getText().toString()));
            }
            VideoPlayInputContainer.this.f21698g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
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
                VideoPlayInputContainer.this.f21697f.setSelection(VideoPlayInputContainer.this.o);
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
                VideoPlayInputContainer.this.d(new d.b.i0.w.a(5, -1, null));
                VideoPlayInputContainer.this.f21697f.requestFocus();
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
            VideoPlayInputContainer.this.d(new d.b.i0.w.a(8, -1, null));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.f {
        public e() {
        }

        @Override // d.b.j0.k0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            VideoPlayInputContainer.this.f21697f.setText(spannableStringBuilder);
            VideoPlayInputContainer.this.f21697f.setSelection(VideoPlayInputContainer.this.f21697f.getText().length());
            VideoPlayInputContainer.this.d(new d.b.i0.w.a(5, -1, null));
            VideoPlayInputContainer.this.requestFocus();
        }
    }

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    @Override // d.b.i0.w.n
    public void b() {
        EditText editText = this.f21697f;
        if (editText != null) {
            editText.setFocusable(true);
            this.f21697f.setFocusableInTouchMode(true);
            this.f21697f.requestFocus();
            l.J(getContext(), this.f21697f);
        }
        setVisibility(0);
    }

    @Override // d.b.i0.w.n
    public void d(d.b.i0.w.a aVar) {
        EditorTools editorTools = this.f21696e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public EditText getInputView() {
        return this.f21697f;
    }

    @Override // d.b.i0.w.n
    public int getToolId() {
        return this.l;
    }

    @Override // d.b.i0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.i0.w.n
    public void init() {
    }

    public final void k() {
        if (this.f21698g.isEnabled()) {
            SkinManager.setViewTextColor(this.f21698g, R.color.CAM_X0302, 1, this.p);
        } else {
            SkinManager.setViewTextColor(this.f21698g, R.color.CAM_X0107, 1);
        }
    }

    public final void l(Context context) {
        ImageView imageView = new ImageView(context);
        this.f21699h = imageView;
        imageView.setEnabled(true);
        this.f21699h.setPadding(0, 0, l.g(context, R.dimen.tbds30), l.g(context, R.dimen.tbds24));
        this.f21699h.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.j.addView(this.f21699h, layoutParams);
    }

    public final void m(Context context) {
        EditText editText = new EditText(context);
        this.f21697f = editText;
        editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f21697f.setMaxLines(4);
        this.f21697f.setGravity(16);
        this.f21697f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f21697f.setBackgroundResource(R.color.common_color_10022);
        j.e(this.f21697f, R.drawable.edittext_cursor);
        this.f21697f.setPadding(0, l.g(context, R.dimen.ds24), l.g(context, R.dimen.ds54), l.g(context, R.dimen.ds24));
        this.f21697f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.f21697f.addTextChangedListener(new b());
        this.f21697f.setHint(context.getString(R.string.reply_something));
        this.f21697f.setOnTouchListener(new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.j.addView(this.f21697f, layoutParams);
    }

    public final void n(Context context) {
        TextView textView = new TextView(context);
        this.f21698g = textView;
        textView.setGravity(17);
        this.f21698g.setIncludeFontPadding(false);
        this.f21698g.setEnabled(false);
        this.f21698g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.f21698g.setText(R.string.send_replay);
        this.f21698g.setOnClickListener(new d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.g(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.j.addView(this.f21698g, layoutParams);
    }

    public final void o(v vVar) {
        if (!this.i || vVar.e() == EmotionGroupType.LOCAL) {
            String obj = this.f21697f.getText().toString();
            if (this.m && d.b.j0.k0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.b.j0.k0.b.b(getContext(), vVar, this.f21697f);
            }
        }
    }

    @Override // d.b.i0.w.b
    public void onAction(d.b.i0.w.a aVar) {
        Object obj;
        if (aVar == null) {
            return;
        }
        int i = aVar.f52278a;
        if (i == 3) {
            if (this.f21697f.getSelectionStart() > 0) {
                String substring = this.f21697f.getText().toString().substring(0, this.f21697f.getSelectionStart());
                Matcher matcher = d.b.j0.k0.a.f58263b.matcher(substring);
                if (matcher.find()) {
                    this.f21697f.getText().delete(this.f21697f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f21697f.getSelectionStart());
                } else {
                    this.f21697f.getText().delete(this.f21697f.getSelectionStart() - 1, this.f21697f.getSelectionStart());
                }
            }
        } else if (i == 6) {
            Object obj2 = aVar.f52280c;
            if (obj2 == null) {
                this.f21697f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f21697f.setText((CharSequence) null);
                } else {
                    d.b.j0.k0.b.d(getContext(), (String) aVar.f52280c, new e());
                }
            }
        } else if (i == 9) {
            if (((Boolean) aVar.f52280c).booleanValue()) {
                this.f21697f.setText((CharSequence) null);
            }
            this.f21698g.setEnabled(false);
            k();
        } else if (i == 24 && (obj = aVar.f52280c) != null && (obj instanceof v)) {
            v vVar = (v) obj;
            if (vVar.e() == EmotionGroupType.NET_SUG) {
                p(vVar);
            } else {
                o(vVar);
            }
        }
    }

    @Override // d.b.i0.w.n
    public void onChangeSkinType(int i) {
        this.p = i;
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f21697f, R.color.CAM_X0106, 2, i);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.e(this.f21697f, R.drawable.edittext_cursor);
            this.f21697f.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            j.e(this.f21697f, R.drawable.edittext_cursor_1);
            this.f21697f.setHintTextColor(SkinManager.getColor(i, R.color.CAM_X0109));
        }
        k();
        SkinManager.setImageResource(this.f21699h, R.drawable.pbeditor_face_button);
    }

    public final void p(v vVar) {
        if (vVar == null || TextUtils.isEmpty(vVar.b()) || TextUtils.isEmpty(vVar.f())) {
            return;
        }
        String obj = this.f21697f.getText().toString();
        if (this.m && d.b.j0.k0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.b.j0.k0.b.c(getContext(), vVar, this.f21697f);
        }
    }

    @Override // d.b.i0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f21696e = editorTools;
    }

    @Override // d.b.i0.w.n
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
