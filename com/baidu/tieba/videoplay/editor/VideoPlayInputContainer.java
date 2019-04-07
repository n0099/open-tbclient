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
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools VN;
    private int VO;
    private int bUM;
    private boolean cjV;
    private boolean cjW;
    private boolean cjX;
    private int cjY;
    private LinearLayout ckB;
    private EditText ckx;
    private ImageView fbA;
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
        this.cjV = false;
        this.cjW = true;
        this.cjX = true;
        this.cjY = -1;
        this.bUM = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.tbds144));
        this.ckB = new LinearLayout(getContext());
        this.ckB.setOrientation(0);
        this.ckB.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, d.e.ds90));
        addView(this.ckB, new LinearLayout.LayoutParams(-1, -2));
        eA(context);
        dh(context);
        dg(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void eA(Context context) {
        this.fbA = new ImageView(context);
        this.fbA.setEnabled(true);
        this.fbA.setPadding(0, 0, com.baidu.adp.lib.util.l.h(context, d.e.tbds30), com.baidu.adp.lib.util.l.h(context, d.e.tbds24));
        this.fbA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.ckB.addView(this.fbA, layoutParams);
    }

    private void dh(Context context) {
        this.ckx = new EditText(context);
        this.ckx.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.ckx.setMaxLines(4);
        this.ckx.setGravity(16);
        this.ckx.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.ckx.setBackgroundResource(d.C0277d.common_color_10022);
        e(this.ckx, d.f.edittext_cursor);
        this.ckx.setPadding(0, com.baidu.adp.lib.util.l.h(context, d.e.ds24), com.baidu.adp.lib.util.l.h(context, d.e.ds54), com.baidu.adp.lib.util.l.h(context, d.e.ds24));
        this.ckx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ckx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.cjX) {
                    VideoPlayInputContainer.this.cjX = true;
                    if (VideoPlayInputContainer.this.cjY != -1) {
                        VideoPlayInputContainer.this.ckx.setSelection(VideoPlayInputContainer.this.cjY);
                        VideoPlayInputContainer.this.cjY = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.ckx.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cmN();
            }
        });
        this.ckx.setHint(context.getString(d.j.reply_something));
        this.ckx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.ckx.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.ckB.addView(this.ckx, layoutParams);
    }

    private void e(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void dg(Context context) {
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
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.h(context, d.e.tbds18));
        layoutParams.gravity = 80;
        this.ckB.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ckx.getSelectionStart() > 0) {
                        String substring = this.ckx.getText().toString().substring(0, this.ckx.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eHn.matcher(substring);
                        if (matcher.find()) {
                            this.ckx.getText().delete(this.ckx.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ckx.getSelectionStart());
                            return;
                        }
                        this.ckx.getText().delete(this.ckx.getSelectionStart() - 1, this.ckx.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.ckx.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ckx.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.ckx.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.ckx.setSelection(VideoPlayInputContainer.this.ckx.getText().length());
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
                        this.ckx.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cmN();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.agq() == EmotionGroupType.NET_SUG) {
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
            String obj = this.ckx.getText().toString();
            if (this.cjW && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.ckx);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cjV || pVar.agq() == EmotionGroupType.LOCAL) {
            String obj = this.ckx.getText().toString();
            if (this.cjW && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.ckx);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.ckx != null) {
            this.ckx.setFocusable(true);
            this.ckx.setFocusableInTouchMode(true);
            this.ckx.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.ckx);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.bUM = i;
        al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
        al.c(this.ckx, d.C0277d.cp_cont_f, 2, i);
        al.l(this, d.C0277d.cp_bg_line_d);
        if (i == 0) {
            e(this.ckx, d.f.edittext_cursor);
            this.ckx.setHintTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_d));
        } else {
            e(this.ckx, d.f.edittext_cursor_1);
            this.ckx.setHintTextColor(al.getColor(i, d.C0277d.cp_cont_d));
        }
        cmN();
        al.c(this.fbA, d.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmN() {
        if (this.mSendView.isEnabled()) {
            al.c(this.mSendView, d.C0277d.cp_link_tip_a, 1, this.bUM);
        } else {
            al.d(this.mSendView, d.C0277d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.ckx;
    }
}
