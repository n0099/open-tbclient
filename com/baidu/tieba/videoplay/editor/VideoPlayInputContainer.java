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
    private int aIf;
    private EditText aWL;
    private LinearLayout aWP;
    private boolean aWj;
    private boolean aWk;
    private boolean aWl;
    private int aWm;
    private ImageView hER;
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
        this.aWj = false;
        this.aWk = true;
        this.aWl = true;
        this.aWm = -1;
        this.aIf = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0200e.tbds144));
        this.aWP = new LinearLayout(getContext());
        this.aWP.setOrientation(0);
        this.aWP.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds90));
        addView(this.aWP, new LinearLayout.LayoutParams(-1, -2));
        db(context);
        bN(context);
        bM(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void db(Context context) {
        this.hER = new ImageView(context);
        this.hER.setEnabled(true);
        this.hER.setPadding(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds30), com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds24));
        this.hER.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.aWP.addView(this.hER, layoutParams);
    }

    private void bN(Context context) {
        this.aWL = new EditText(context);
        this.aWL.setMinHeight(context.getResources().getDimensionPixelSize(e.C0200e.ds32));
        this.aWL.setMaxLines(4);
        this.aWL.setGravity(16);
        this.aWL.setTextSize(0, getResources().getDimensionPixelSize(e.C0200e.ds32));
        this.aWL.setBackgroundResource(e.d.common_color_10022);
        a(this.aWL, e.f.edittext_cursor);
        this.aWL.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0200e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds24));
        this.aWL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aWL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aWl) {
                    VideoPlayInputContainer.this.aWl = true;
                    if (VideoPlayInputContainer.this.aWm != -1) {
                        VideoPlayInputContainer.this.aWL.setSelection(VideoPlayInputContainer.this.aWm);
                        VideoPlayInputContainer.this.aWm = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.aWL.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bJJ();
            }
        });
        this.aWL.setHint(context.getString(e.j.reply_something));
        this.aWL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.aWL.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.aWP.addView(this.aWL, layoutParams);
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

    private void bM(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0200e.fontsize32));
        this.mSendView.setText(e.j.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.h(context, e.C0200e.tbds18));
        layoutParams.gravity = 80;
        this.aWP.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aWL.getSelectionStart() > 0) {
                        String substring = this.aWL.getText().toString().substring(0, this.aWL.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.dko.matcher(substring);
                        if (matcher.find()) {
                            this.aWL.getText().delete(this.aWL.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aWL.getSelectionStart());
                            return;
                        }
                        this.aWL.getText().delete(this.aWL.getSelectionStart() - 1, this.aWL.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.aWL.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aWL.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.aWL.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.aWL.setSelection(VideoPlayInputContainer.this.aWL.getText().length());
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
                        this.aWL.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bJJ();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.FI() == EmotionGroupType.NET_SUG) {
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
            String obj = this.aWL.getText().toString();
            if (this.aWk && com.baidu.tieba.face.a.mH(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bz().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.aWL);
            }
        }
    }

    private void b(p pVar) {
        if (!this.aWj || pVar.FI() == EmotionGroupType.LOCAL) {
            String obj = this.aWL.getText().toString();
            if (this.aWk && com.baidu.tieba.face.a.mH(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bz().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.aWL);
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
    public void pO() {
        if (this.aWL != null) {
            this.aWL.setFocusable(true);
            this.aWL.setFocusableInTouchMode(true);
            this.aWL.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.aWL);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aIf = i;
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.b(this.aWL, e.d.cp_cont_f, 2, i);
        al.j(this, e.d.cp_bg_line_d);
        if (i == 0) {
            a(this.aWL, e.f.edittext_cursor);
            this.aWL.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_d));
        } else {
            a(this.aWL, e.f.edittext_cursor_1);
            this.aWL.setHintTextColor(al.getColor(i, e.d.cp_cont_d));
        }
        bJJ();
        al.c(this.hER, e.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, this.aIf);
        } else {
            al.c(this.mSendView, e.d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.aWL;
    }
}
