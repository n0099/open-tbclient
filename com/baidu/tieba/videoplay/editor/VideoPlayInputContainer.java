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
    private EditorTools Tj;
    private int Tk;
    private int aMj;
    private EditText baW;
    private boolean bau;
    private boolean bav;
    private boolean baw;
    private int bax;
    private LinearLayout bba;
    private ImageView hQu;
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
        this.bau = false;
        this.bav = true;
        this.baw = true;
        this.bax = -1;
        this.aMj = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0210e.tbds144));
        this.bba = new LinearLayout(getContext());
        this.bba.setOrientation(0);
        this.bba.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds90));
        addView(this.bba, new LinearLayout.LayoutParams(-1, -2));
        df(context);
        bQ(context);
        bP(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void df(Context context) {
        this.hQu = new ImageView(context);
        this.hQu.setEnabled(true);
        this.hQu.setPadding(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds30), com.baidu.adp.lib.util.l.h(context, e.C0210e.tbds24));
        this.hQu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.bba.addView(this.hQu, layoutParams);
    }

    private void bQ(Context context) {
        this.baW = new EditText(context);
        this.baW.setMinHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.baW.setMaxLines(4);
        this.baW.setGravity(16);
        this.baW.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.baW.setBackgroundResource(e.d.common_color_10022);
        a(this.baW, e.f.edittext_cursor);
        this.baW.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24));
        this.baW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.baW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.baw) {
                    VideoPlayInputContainer.this.baw = true;
                    if (VideoPlayInputContainer.this.bax != -1) {
                        VideoPlayInputContainer.this.baW.setSelection(VideoPlayInputContainer.this.bax);
                        VideoPlayInputContainer.this.bax = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.baW.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bNl();
            }
        });
        this.baW.setHint(context.getString(e.j.reply_something));
        this.baW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.baW.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.bba.addView(this.baW, layoutParams);
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
        this.bba.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.baW.getSelectionStart() > 0) {
                        String substring = this.baW.getText().toString().substring(0, this.baW.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.dun.matcher(substring);
                        if (matcher.find()) {
                            this.baW.getText().delete(this.baW.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.baW.getSelectionStart());
                            return;
                        }
                        this.baW.getText().delete(this.baW.getSelectionStart() - 1, this.baW.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.baW.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.baW.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.baW.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.baW.setSelection(VideoPlayInputContainer.this.baW.getText().length());
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
                        this.baW.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bNl();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.Ha() == EmotionGroupType.NET_SUG) {
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
            String obj = this.baW.getText().toString();
            if (this.bav && com.baidu.tieba.face.a.nz(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CQ().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.baW);
            }
        }
    }

    private void b(p pVar) {
        if (!this.bau || pVar.Ha() == EmotionGroupType.LOCAL) {
            String obj = this.baW.getText().toString();
            if (this.bav && com.baidu.tieba.face.a.nz(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CQ().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.baW);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        if (this.baW != null) {
            this.baW.setFocusable(true);
            this.baW.setFocusableInTouchMode(true);
            this.baW.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.baW);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aMj = i;
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.b(this.baW, e.d.cp_cont_f, 2, i);
        al.j(this, e.d.cp_bg_line_d);
        if (i == 0) {
            a(this.baW, e.f.edittext_cursor);
            this.baW.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_d));
        } else {
            a(this.baW, e.f.edittext_cursor_1);
            this.baW.setHintTextColor(al.getColor(i, e.d.cp_cont_d));
        }
        bNl();
        al.c(this.hQu, e.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNl() {
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, this.aMj);
        } else {
            al.c(this.mSendView, e.d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.baW;
    }
}
