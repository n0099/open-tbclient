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
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools TB;
    private int TC;
    private int ccI;
    private EditText csG;
    private LinearLayout csK;
    private boolean cse;
    private boolean csf;
    private boolean csg;
    private int csh;
    private ImageView frP;
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
        this.cse = false;
        this.csf = true;
        this.csg = true;
        this.csh = -1;
        this.ccI = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.csK = new LinearLayout(getContext());
        this.csK.setOrientation(0);
        this.csK.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.ds90));
        addView(this.csK, new LinearLayout.LayoutParams(-1, -2));
        eq(context);
        cN(context);
        cM(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void eq(Context context) {
        this.frP = new ImageView(context);
        this.frP.setEnabled(true);
        this.frP.setPadding(0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds30), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds24));
        this.frP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.csK.addView(this.frP, layoutParams);
    }

    private void cN(Context context) {
        this.csG = new EditText(context);
        this.csG.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csG.setMaxLines(4);
        this.csG.setGravity(16);
        this.csG.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csG.setBackgroundResource(R.color.common_color_10022);
        e(this.csG, R.drawable.edittext_cursor);
        this.csG.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.csG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.csG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.csg) {
                    VideoPlayInputContainer.this.csg = true;
                    if (VideoPlayInputContainer.this.csh != -1) {
                        VideoPlayInputContainer.this.csG.setSelection(VideoPlayInputContainer.this.csh);
                        VideoPlayInputContainer.this.csh = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.csG.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cuQ();
            }
        });
        this.csG.setHint(context.getString(R.string.reply_something));
        this.csG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.csG.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.csK.addView(this.csG, layoutParams);
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

    private void cM(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.mSendView.setText(R.string.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.csK.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.csG.getSelectionStart() > 0) {
                        String substring = this.csG.getText().toString().substring(0, this.csG.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eXx.matcher(substring);
                        if (matcher.find()) {
                            this.csG.getText().delete(this.csG.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.csG.getSelectionStart());
                            return;
                        }
                        this.csG.getText().delete(this.csG.getSelectionStart() - 1, this.csG.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.csG.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.csG.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.csG.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.csG.setSelection(VideoPlayInputContainer.this.csG.getText().length());
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
                        this.csG.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cuQ();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.alp() == EmotionGroupType.NET_SUG) {
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
            String obj = this.csG.getText().toString();
            if (this.csf && com.baidu.tieba.face.a.vx(obj) >= 10 && getContext() != null) {
                e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.csG);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cse || pVar.alp() == EmotionGroupType.LOCAL) {
            String obj = this.csG.getText().toString();
            if (this.csf && com.baidu.tieba.face.a.vx(obj) >= 10 && getContext() != null) {
                e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.csG);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TB != null) {
            this.TB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TC = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TC;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.csG != null) {
            this.csG.setFocusable(true);
            this.csG.setFocusableInTouchMode(true);
            this.csG.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.csG);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ccI = i;
        al.l(this.mBottomLine, R.color.cp_bg_line_c);
        al.c(this.csG, R.color.cp_cont_f, 2, i);
        al.l(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.csG, R.drawable.edittext_cursor);
            this.csG.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.csG, R.drawable.edittext_cursor_1);
            this.csG.setHintTextColor(al.getColor(i, R.color.cp_cont_d));
        }
        cuQ();
        al.c(this.frP, (int) R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuQ() {
        if (this.mSendView.isEnabled()) {
            al.c(this.mSendView, R.color.cp_link_tip_a, 1, this.ccI);
        } else {
            al.f(this.mSendView, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.csG;
    }
}
