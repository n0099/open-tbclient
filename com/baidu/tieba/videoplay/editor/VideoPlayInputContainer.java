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
import d.a.c.e.p.l;
import d.a.n0.s.c.v;
import d.a.n0.w.n;
import d.a.o0.l0.b;
import d.a.o0.w3.i;
import java.util.regex.Matcher;
/* loaded from: classes5.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f21679e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f21680f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21681g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21682h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21683i;
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
            VideoPlayInputContainer.this.d(new d.a.n0.w.a(1, 5, null));
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
                videoPlayInputContainer.d(new d.a.n0.w.a(4, -1, videoPlayInputContainer.f21680f.getText().toString()));
            }
            VideoPlayInputContainer.this.f21681g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
            VideoPlayInputContainer.this.k();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (VideoPlayInputContainer.this.n) {
                return;
            }
            VideoPlayInputContainer.this.n = true;
            if (VideoPlayInputContainer.this.o != -1) {
                VideoPlayInputContainer.this.f21680f.setSelection(VideoPlayInputContainer.this.o);
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
                VideoPlayInputContainer.this.d(new d.a.n0.w.a(5, -1, null));
                VideoPlayInputContainer.this.f21680f.requestFocus();
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
            VideoPlayInputContainer.this.d(new d.a.n0.w.a(8, -1, null));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.f {
        public e() {
        }

        @Override // d.a.o0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            VideoPlayInputContainer.this.f21680f.setText(spannableStringBuilder);
            VideoPlayInputContainer.this.f21680f.setSelection(VideoPlayInputContainer.this.f21680f.getText().length());
            VideoPlayInputContainer.this.d(new d.a.n0.w.a(5, -1, null));
            VideoPlayInputContainer.this.requestFocus();
        }
    }

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    @Override // d.a.n0.w.n
    public void b() {
        EditText editText = this.f21680f;
        if (editText != null) {
            editText.setFocusable(true);
            this.f21680f.setFocusableInTouchMode(true);
            this.f21680f.requestFocus();
            l.K(getContext(), this.f21680f);
        }
        setVisibility(0);
    }

    @Override // d.a.n0.w.n
    public void d(d.a.n0.w.a aVar) {
        EditorTools editorTools = this.f21679e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public EditText getInputView() {
        return this.f21680f;
    }

    @Override // d.a.n0.w.n
    public int getToolId() {
        return this.l;
    }

    @Override // d.a.n0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.n0.w.n
    public void init() {
    }

    public final void k() {
        if (this.f21681g.isEnabled()) {
            SkinManager.setViewTextColor(this.f21681g, R.color.CAM_X0302, 1, this.p);
        } else {
            SkinManager.setViewTextColor(this.f21681g, R.color.CAM_X0107, 1);
        }
    }

    public final void l(Context context) {
        ImageView imageView = new ImageView(context);
        this.f21682h = imageView;
        imageView.setEnabled(true);
        this.f21682h.setPadding(0, 0, l.g(context, R.dimen.tbds30), l.g(context, R.dimen.tbds24));
        this.f21682h.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.j.addView(this.f21682h, layoutParams);
    }

    public final void m(Context context) {
        EditText editText = new EditText(context);
        this.f21680f = editText;
        editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f21680f.setMaxLines(4);
        this.f21680f.setGravity(16);
        this.f21680f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f21680f.setBackgroundResource(R.color.common_color_10022);
        i.e(this.f21680f, R.drawable.edittext_cursor);
        this.f21680f.setPadding(0, l.g(context, R.dimen.ds24), l.g(context, R.dimen.ds54), l.g(context, R.dimen.ds24));
        this.f21680f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.f21680f.addTextChangedListener(new b());
        this.f21680f.setHint(context.getString(R.string.reply_something));
        this.f21680f.setOnTouchListener(new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.j.addView(this.f21680f, layoutParams);
    }

    public final void n(Context context) {
        TextView textView = new TextView(context);
        this.f21681g = textView;
        textView.setGravity(17);
        this.f21681g.setIncludeFontPadding(false);
        this.f21681g.setEnabled(false);
        this.f21681g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.f21681g.setText(R.string.send_replay);
        this.f21681g.setOnClickListener(new d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.g(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.j.addView(this.f21681g, layoutParams);
    }

    public final void o(v vVar) {
        if (!this.f21683i || vVar.f() == EmotionGroupType.LOCAL) {
            String obj = this.f21680f.getText().toString();
            if (this.m && d.a.o0.l0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.a.o0.l0.b.b(getContext(), vVar, this.f21680f);
            }
        }
    }

    @Override // d.a.n0.w.b
    public void onAction(d.a.n0.w.a aVar) {
        Object obj;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f54625a;
        if (i2 == 3) {
            if (this.f21680f.getSelectionStart() > 0) {
                String substring = this.f21680f.getText().toString().substring(0, this.f21680f.getSelectionStart());
                Matcher matcher = d.a.o0.l0.a.f60968b.matcher(substring);
                if (matcher.find()) {
                    this.f21680f.getText().delete(this.f21680f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f21680f.getSelectionStart());
                } else {
                    this.f21680f.getText().delete(this.f21680f.getSelectionStart() - 1, this.f21680f.getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f54627c;
            if (obj2 == null) {
                this.f21680f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f21680f.setText((CharSequence) null);
                } else {
                    d.a.o0.l0.b.d(getContext(), (String) aVar.f54627c, new e());
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f54627c).booleanValue()) {
                this.f21680f.setText((CharSequence) null);
            }
            this.f21681g.setEnabled(false);
            k();
        } else if (i2 == 24 && (obj = aVar.f54627c) != null && (obj instanceof v)) {
            v vVar = (v) obj;
            if (vVar.f() == EmotionGroupType.NET_SUG) {
                p(vVar);
            } else {
                o(vVar);
            }
        }
    }

    @Override // d.a.n0.w.n
    public void onChangeSkinType(int i2) {
        this.p = i2;
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f21680f, R.color.CAM_X0106, 2, i2);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        if (i2 == 0) {
            i.e(this.f21680f, R.drawable.edittext_cursor);
            this.f21680f.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            i.e(this.f21680f, R.drawable.edittext_cursor_1);
            this.f21680f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
        }
        k();
        SkinManager.setImageResource(this.f21682h, R.drawable.pbeditor_face_button);
    }

    public final void p(v vVar) {
        if (vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = this.f21680f.getText().toString();
        if (this.m && d.a.o0.l0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.a.o0.l0.b.c(getContext(), vVar, this.f21680f);
        }
    }

    @Override // d.a.n0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f21679e = editorTools;
    }

    @Override // d.a.n0.w.n
    public void setToolId(int i2) {
        this.l = i2;
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21683i = false;
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
