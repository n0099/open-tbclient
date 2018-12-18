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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools Ta;
    private int Tb;
    private int aLF;
    private boolean aZG;
    private boolean aZH;
    private boolean aZI;
    private int aZJ;
    private EditText bai;
    private LinearLayout bam;
    private ImageView hMc;
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
        this.aZG = false;
        this.aZH = true;
        this.aZI = true;
        this.aZJ = -1;
        this.aLF = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0210e.tbds144));
        this.bam = new LinearLayout(getContext());
        this.bam.setOrientation(0);
        this.bam.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds90));
        addView(this.bam, new LinearLayout.LayoutParams(-1, -2));
        df(context);
        bQ(context);
        bP(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void df(Context context) {
        this.hMc = new ImageView(context);
        this.hMc.setEnabled(true);
        this.hMc.setPadding(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds30), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds24));
        this.hMc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.bam.addView(this.hMc, layoutParams);
    }

    private void bQ(Context context) {
        this.bai = new EditText(context);
        this.bai.setMinHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.bai.setMaxLines(4);
        this.bai.setGravity(16);
        this.bai.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.bai.setBackgroundResource(e.d.common_color_10022);
        a(this.bai, e.f.edittext_cursor);
        this.bai.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24));
        this.bai.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.bai.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aZI) {
                    VideoPlayInputContainer.this.aZI = true;
                    if (VideoPlayInputContainer.this.aZJ != -1) {
                        VideoPlayInputContainer.this.bai.setSelection(VideoPlayInputContainer.this.aZJ);
                        VideoPlayInputContainer.this.aZJ = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.bai.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bLN();
            }
        });
        this.bai.setHint(context.getString(e.j.reply_something));
        this.bai.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.bai.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.bam.addView(this.bai, layoutParams);
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

    private void bP(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0210e.fontsize32));
        this.mSendView.setText(e.j.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds18));
        layoutParams.gravity = 80;
        this.bam.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.bai.getSelectionStart() > 0) {
                        String substring = this.bai.getText().toString().substring(0, this.bai.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.dqQ.matcher(substring);
                        if (matcher.find()) {
                            this.bai.getText().delete(this.bai.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bai.getSelectionStart());
                            return;
                        }
                        this.bai.getText().delete(this.bai.getSelectionStart() - 1, this.bai.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.bai.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.bai.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.bai.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.bai.setSelection(VideoPlayInputContainer.this.bai.getText().length());
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
                        this.bai.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bLN();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.GM() == EmotionGroupType.NET_SUG) {
                            a(pVar);
                            return;
                        } else {
                            b(pVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.bai.getText().toString();
            if (this.aZH && com.baidu.tieba.face.a.ng(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CD().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.bai);
            }
        }
    }

    private void b(p pVar) {
        if (!this.aZG || pVar.GM() == EmotionGroupType.LOCAL) {
            String obj = this.bai.getText().toString();
            if (this.aZH && com.baidu.tieba.face.a.ng(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CD().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.bai);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        if (this.bai != null) {
            this.bai.setFocusable(true);
            this.bai.setFocusableInTouchMode(true);
            this.bai.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.bai);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aLF = i;
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.b(this.bai, e.d.cp_cont_f, 2, i);
        al.j(this, e.d.cp_bg_line_d);
        if (i == 0) {
            a(this.bai, e.f.edittext_cursor);
            this.bai.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_d));
        } else {
            a(this.bai, e.f.edittext_cursor_1);
            this.bai.setHintTextColor(al.getColor(i, e.d.cp_cont_d));
        }
        bLN();
        al.c(this.hMc, e.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLN() {
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, this.aLF);
        } else {
            al.c(this.mSendView, e.d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.bai;
    }
}
