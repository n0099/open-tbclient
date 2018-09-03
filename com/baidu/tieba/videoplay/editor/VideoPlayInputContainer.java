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
import com.baidu.tieba.f;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes2.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools Qg;
    private int Qh;
    private boolean aNA;
    private boolean aNB;
    private boolean aNC;
    private int aND;
    private EditText aOc;
    private LinearLayout aOg;
    private int azF;
    private ImageView hoc;
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
        this.aNA = false;
        this.aNB = true;
        this.aNC = true;
        this.aND = -1;
        this.azF = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(f.e.tbds144));
        this.aOg = new LinearLayout(getContext());
        this.aOg.setOrientation(0);
        this.aOg.setMinimumHeight(com.baidu.adp.lib.util.l.f(context, f.e.ds90));
        addView(this.aOg, new LinearLayout.LayoutParams(-1, -2));
        cn(context);
        bc(context);
        bb(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(getContext(), f.e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void cn(Context context) {
        this.hoc = new ImageView(context);
        this.hoc.setEnabled(true);
        this.hoc.setPadding(0, 0, com.baidu.adp.lib.util.l.f(context, f.e.tbds30), com.baidu.adp.lib.util.l.f(context, f.e.tbds24));
        this.hoc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.aOg.addView(this.hoc, layoutParams);
    }

    private void bc(Context context) {
        this.aOc = new EditText(context);
        this.aOc.setMinHeight(context.getResources().getDimensionPixelSize(f.e.ds32));
        this.aOc.setMaxLines(4);
        this.aOc.setGravity(16);
        this.aOc.setTextSize(0, getResources().getDimensionPixelSize(f.e.ds32));
        this.aOc.setBackgroundResource(f.d.common_color_10022);
        a(this.aOc, f.C0146f.edittext_cursor);
        this.aOc.setPadding(0, com.baidu.adp.lib.util.l.f(context, f.e.ds24), com.baidu.adp.lib.util.l.f(context, f.e.ds54), com.baidu.adp.lib.util.l.f(context, f.e.ds24));
        this.aOc.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aOc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aNC) {
                    VideoPlayInputContainer.this.aNC = true;
                    if (VideoPlayInputContainer.this.aND != -1) {
                        VideoPlayInputContainer.this.aOc.setSelection(VideoPlayInputContainer.this.aND);
                        VideoPlayInputContainer.this.aND = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.aOc.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bEh();
            }
        });
        this.aOc.setHint(context.getString(f.j.reply_something));
        this.aOc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.aOc.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.aOg.addView(this.aOc, layoutParams);
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

    private void bb(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(f.e.fontsize32));
        this.mSendView.setText(f.j.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.f(context, f.e.tbds18));
        layoutParams.gravity = 80;
        this.aOg.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aOc.getSelectionStart() > 0) {
                        String substring = this.aOc.getText().toString().substring(0, this.aOc.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cVf.matcher(substring);
                        if (matcher.find()) {
                            this.aOc.getText().delete(this.aOc.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aOc.getSelectionStart());
                            return;
                        }
                        this.aOc.getText().delete(this.aOc.getSelectionStart() - 1, this.aOc.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.aOc.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aOc.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.aOc.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.aOc.setSelection(VideoPlayInputContainer.this.aOc.getText().length());
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
                        this.aOc.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bEh();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof n)) {
                        n nVar = (n) aVar.data;
                        if (nVar.Ci() == EmotionGroupType.NET_SUG) {
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
            String obj = this.aOc.getText().toString();
            if (this.aNB && com.baidu.tieba.face.a.lC(obj) >= 10 && getContext() != null) {
                e.yd().showToast(f.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aOc);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aNA || nVar.Ci() == EmotionGroupType.LOCAL) {
            String obj = this.aOc.getText().toString();
            if (this.aNB && com.baidu.tieba.face.a.lC(obj) >= 10 && getContext() != null) {
                e.yd().showToast(f.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aOc);
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
    public void oC() {
        if (this.aOc != null) {
            this.aOc.setFocusable(true);
            this.aOc.setFocusableInTouchMode(true);
            this.aOc.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), this.aOc);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.azF = i;
        am.j(this.mBottomLine, f.d.cp_bg_line_c);
        am.b(this.aOc, f.d.cp_cont_f, 2, i);
        am.j(this, f.d.cp_bg_line_d);
        if (i == 0) {
            a(this.aOc, f.C0146f.edittext_cursor);
            this.aOc.setHintTextColor(getContext().getResources().getColor(f.d.cp_cont_d));
        } else {
            a(this.aOc, f.C0146f.edittext_cursor_1);
            this.aOc.setHintTextColor(am.getColor(i, f.d.cp_cont_d));
        }
        bEh();
        am.c(this.hoc, f.C0146f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEh() {
        if (this.mSendView.isEnabled()) {
            am.b(this.mSendView, f.d.cp_link_tip_a, 1, this.azF);
        } else {
            am.c(this.mSendView, f.d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.aOc;
    }
}
