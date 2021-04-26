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
import d.a.i0.s.c.v;
import d.a.i0.w.n;
import d.a.j0.k0.b;
import d.a.j0.v3.i;
import java.util.regex.Matcher;
/* loaded from: classes5.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f22340e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f22341f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22342g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22343h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22344i;
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
            VideoPlayInputContainer.this.d(new d.a.i0.w.a(1, 5, null));
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
                videoPlayInputContainer.d(new d.a.i0.w.a(4, -1, videoPlayInputContainer.f22341f.getText().toString()));
            }
            VideoPlayInputContainer.this.f22342g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
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
                VideoPlayInputContainer.this.f22341f.setSelection(VideoPlayInputContainer.this.o);
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
                VideoPlayInputContainer.this.d(new d.a.i0.w.a(5, -1, null));
                VideoPlayInputContainer.this.f22341f.requestFocus();
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
            VideoPlayInputContainer.this.d(new d.a.i0.w.a(8, -1, null));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.f {
        public e() {
        }

        @Override // d.a.j0.k0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            VideoPlayInputContainer.this.f22341f.setText(spannableStringBuilder);
            VideoPlayInputContainer.this.f22341f.setSelection(VideoPlayInputContainer.this.f22341f.getText().length());
            VideoPlayInputContainer.this.d(new d.a.i0.w.a(5, -1, null));
            VideoPlayInputContainer.this.requestFocus();
        }
    }

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    @Override // d.a.i0.w.n
    public void b() {
        EditText editText = this.f22341f;
        if (editText != null) {
            editText.setFocusable(true);
            this.f22341f.setFocusableInTouchMode(true);
            this.f22341f.requestFocus();
            l.K(getContext(), this.f22341f);
        }
        setVisibility(0);
    }

    @Override // d.a.i0.w.n
    public void d(d.a.i0.w.a aVar) {
        EditorTools editorTools = this.f22340e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public EditText getInputView() {
        return this.f22341f;
    }

    @Override // d.a.i0.w.n
    public int getToolId() {
        return this.l;
    }

    @Override // d.a.i0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.i0.w.n
    public void init() {
    }

    public final void k() {
        if (this.f22342g.isEnabled()) {
            SkinManager.setViewTextColor(this.f22342g, R.color.CAM_X0302, 1, this.p);
        } else {
            SkinManager.setViewTextColor(this.f22342g, R.color.CAM_X0107, 1);
        }
    }

    public final void l(Context context) {
        ImageView imageView = new ImageView(context);
        this.f22343h = imageView;
        imageView.setEnabled(true);
        this.f22343h.setPadding(0, 0, l.g(context, R.dimen.tbds30), l.g(context, R.dimen.tbds24));
        this.f22343h.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.j.addView(this.f22343h, layoutParams);
    }

    public final void m(Context context) {
        EditText editText = new EditText(context);
        this.f22341f = editText;
        editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f22341f.setMaxLines(4);
        this.f22341f.setGravity(16);
        this.f22341f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f22341f.setBackgroundResource(R.color.common_color_10022);
        i.e(this.f22341f, R.drawable.edittext_cursor);
        this.f22341f.setPadding(0, l.g(context, R.dimen.ds24), l.g(context, R.dimen.ds54), l.g(context, R.dimen.ds24));
        this.f22341f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.f22341f.addTextChangedListener(new b());
        this.f22341f.setHint(context.getString(R.string.reply_something));
        this.f22341f.setOnTouchListener(new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.j.addView(this.f22341f, layoutParams);
    }

    public final void n(Context context) {
        TextView textView = new TextView(context);
        this.f22342g = textView;
        textView.setGravity(17);
        this.f22342g.setIncludeFontPadding(false);
        this.f22342g.setEnabled(false);
        this.f22342g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.f22342g.setText(R.string.send_replay);
        this.f22342g.setOnClickListener(new d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.g(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.j.addView(this.f22342g, layoutParams);
    }

    public final void o(v vVar) {
        if (!this.f22344i || vVar.e() == EmotionGroupType.LOCAL) {
            String obj = this.f22341f.getText().toString();
            if (this.m && d.a.j0.k0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.a.j0.k0.b.b(getContext(), vVar, this.f22341f);
            }
        }
    }

    @Override // d.a.i0.w.b
    public void onAction(d.a.i0.w.a aVar) {
        Object obj;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f49949a;
        if (i2 == 3) {
            if (this.f22341f.getSelectionStart() > 0) {
                String substring = this.f22341f.getText().toString().substring(0, this.f22341f.getSelectionStart());
                Matcher matcher = d.a.j0.k0.a.f56257b.matcher(substring);
                if (matcher.find()) {
                    this.f22341f.getText().delete(this.f22341f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f22341f.getSelectionStart());
                } else {
                    this.f22341f.getText().delete(this.f22341f.getSelectionStart() - 1, this.f22341f.getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f49951c;
            if (obj2 == null) {
                this.f22341f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f22341f.setText((CharSequence) null);
                } else {
                    d.a.j0.k0.b.d(getContext(), (String) aVar.f49951c, new e());
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f49951c).booleanValue()) {
                this.f22341f.setText((CharSequence) null);
            }
            this.f22342g.setEnabled(false);
            k();
        } else if (i2 == 24 && (obj = aVar.f49951c) != null && (obj instanceof v)) {
            v vVar = (v) obj;
            if (vVar.e() == EmotionGroupType.NET_SUG) {
                p(vVar);
            } else {
                o(vVar);
            }
        }
    }

    @Override // d.a.i0.w.n
    public void onChangeSkinType(int i2) {
        this.p = i2;
        SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f22341f, R.color.CAM_X0106, 2, i2);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        if (i2 == 0) {
            i.e(this.f22341f, R.drawable.edittext_cursor);
            this.f22341f.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            i.e(this.f22341f, R.drawable.edittext_cursor_1);
            this.f22341f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
        }
        k();
        SkinManager.setImageResource(this.f22343h, R.drawable.pbeditor_face_button);
    }

    public final void p(v vVar) {
        if (vVar == null || TextUtils.isEmpty(vVar.b()) || TextUtils.isEmpty(vVar.f())) {
            return;
        }
        String obj = this.f22341f.getText().toString();
        if (this.m && d.a.j0.k0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.a.j0.k0.b.c(getContext(), vVar, this.f22341f);
        }
    }

    @Override // d.a.i0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f22340e = editorTools;
    }

    @Override // d.a.i0.w.n
    public void setToolId(int i2) {
        this.l = i2;
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22344i = false;
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
