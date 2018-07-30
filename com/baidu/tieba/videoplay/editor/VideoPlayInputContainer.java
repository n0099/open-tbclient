package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.support.annotation.Nullable;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes2.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools Qg;
    private int Qh;
    private boolean aND;
    private boolean aNE;
    private boolean aNF;
    private int aNG;
    private EditText aOf;
    private LinearLayout aOj;
    private int azI;
    private ImageView hob;
    private View mBottomLine;
    private TextView mSendView;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aND = false;
        this.aNE = true;
        this.aNF = true;
        this.aNG = -1;
        this.azI = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.tbds144));
        this.aOj = new LinearLayout(getContext());
        this.aOj.setOrientation(0);
        this.aOj.setMinimumHeight(com.baidu.adp.lib.util.l.f(context, d.e.ds90));
        addView(this.aOj, new LinearLayout.LayoutParams(-1, -2));
        co(context);
        bd(context);
        bc(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void co(Context context) {
        this.hob = new ImageView(context);
        this.hob.setEnabled(true);
        this.hob.setPadding(0, 0, com.baidu.adp.lib.util.l.f(context, d.e.tbds30), com.baidu.adp.lib.util.l.f(context, d.e.tbds24));
        this.hob.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.aOj.addView(this.hob, layoutParams);
    }

    private void bd(Context context) {
        this.aOf = new EditText(context);
        this.aOf.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aOf.setMaxLines(4);
        this.aOf.setGravity(16);
        this.aOf.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aOf.setBackgroundResource(d.C0140d.common_color_10022);
        a(this.aOf, d.f.edittext_cursor);
        this.aOf.setPadding(0, com.baidu.adp.lib.util.l.f(context, d.e.ds24), com.baidu.adp.lib.util.l.f(context, d.e.ds54), com.baidu.adp.lib.util.l.f(context, d.e.ds24));
        this.aOf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aOf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aNF) {
                    VideoPlayInputContainer.this.aNF = true;
                    if (VideoPlayInputContainer.this.aNG != -1) {
                        VideoPlayInputContainer.this.aOf.setSelection(VideoPlayInputContainer.this.aNG);
                        VideoPlayInputContainer.this.aNG = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.aOf.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bEf();
            }
        });
        this.aOf.setHint(context.getString(d.j.reply_something));
        this.aOf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.aOf.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.aOj.addView(this.aOf, layoutParams);
    }

    private void a(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void bc(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.j.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.f(context, d.e.tbds18));
        layoutParams.gravity = 80;
        this.aOj.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aOf.getSelectionStart() > 0) {
                        String substring = this.aOf.getText().toString().substring(0, this.aOf.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cVj.matcher(substring);
                        if (matcher.find()) {
                            this.aOf.getText().delete(this.aOf.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aOf.getSelectionStart());
                            return;
                        }
                        this.aOf.getText().delete(this.aOf.getSelectionStart() - 1, this.aOf.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.aOf.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aOf.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.aOf.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.aOf.setSelection(VideoPlayInputContainer.this.aOf.getText().length());
                                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    VideoPlayInputContainer.this.requestFocus();
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aOf.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bEf();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof n)) {
                        n nVar = (n) aVar.data;
                        if (nVar.Cl() == EmotionGroupType.NET_SUG) {
                            a(nVar);
                            return;
                        } else {
                            b(nVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aOf.getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lA(obj) >= 10 && getContext() != null) {
                e.ye().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aOf);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aND || nVar.Cl() == EmotionGroupType.LOCAL) {
            String obj = this.aOf.getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lA(obj) >= 10 && getContext() != null) {
                e.ye().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aOf);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oF() {
        if (this.aOf != null) {
            this.aOf.setFocusable(true);
            this.aOf.setFocusableInTouchMode(true);
            this.aOf.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), this.aOf);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.azI = i;
        am.j(this.mBottomLine, d.C0140d.cp_bg_line_c);
        am.b(this.aOf, d.C0140d.cp_cont_f, 2, i);
        am.j(this, d.C0140d.cp_bg_line_d);
        if (i == 0) {
            a(this.aOf, d.f.edittext_cursor);
            this.aOf.setHintTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_d));
        } else {
            a(this.aOf, d.f.edittext_cursor_1);
            this.aOf.setHintTextColor(am.getColor(i, d.C0140d.cp_cont_d));
        }
        bEf();
        am.c(this.hob, d.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEf() {
        if (this.mSendView.isEnabled()) {
            am.b(this.mSendView, d.C0140d.cp_link_tip_a, 1, this.azI);
        } else {
            am.c(this.mSendView, d.C0140d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.aOf;
    }
}
