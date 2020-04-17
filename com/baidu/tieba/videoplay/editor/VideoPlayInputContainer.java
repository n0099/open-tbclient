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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes11.dex */
public class VideoPlayInputContainer extends LinearLayout implements m {
    private EditorTools Za;
    private int Zb;
    private int afT;
    private TextView bbL;
    private EditText dYK;
    private LinearLayout dYO;
    private boolean dYg;
    private boolean dYh;
    private boolean dYi;
    private int dYj;
    private ImageView hbn;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYg = false;
        this.dYh = true;
        this.dYi = true;
        this.dYj = -1;
        this.afT = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.dYO = new LinearLayout(getContext());
        this.dYO.setOrientation(0);
        this.dYO.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.dYO, new LinearLayout.LayoutParams(-1, -2));
        fs(context);
        dM(context);
        dL(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fs(Context context) {
        this.hbn = new ImageView(context);
        this.hbn.setEnabled(true);
        this.hbn.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.hbn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.dYO.addView(this.hbn, layoutParams);
    }

    private void dM(Context context) {
        this.dYK = new EditText(context);
        this.dYK.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYK.setMaxLines(4);
        this.dYK.setGravity(16);
        this.dYK.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYK.setBackgroundResource(R.color.common_color_10022);
        e(this.dYK, R.drawable.edittext_cursor);
        this.dYK.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dYK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dYK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.dYi) {
                    VideoPlayInputContainer.this.dYi = true;
                    if (VideoPlayInputContainer.this.dYj != -1) {
                        VideoPlayInputContainer.this.dYK.setSelection(VideoPlayInputContainer.this.dYj);
                        VideoPlayInputContainer.this.dYj = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.dYK.getText().toString()));
                }
                VideoPlayInputContainer.this.bbL.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.deu();
            }
        });
        this.dYK.setHint(context.getString(R.string.reply_something));
        this.dYK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.dYK.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.dYO.addView(this.dYK, layoutParams);
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

    private void dL(Context context) {
        this.bbL = new TextView(context);
        this.bbL.setGravity(17);
        this.bbL.setIncludeFontPadding(false);
        this.bbL.setEnabled(false);
        this.bbL.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bbL.setText(R.string.send_replay);
        this.bbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.dYO.addView(this.bbL, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dYK.getSelectionStart() > 0) {
                        String substring = this.dYK.getText().toString().substring(0, this.dYK.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gKy.matcher(substring);
                        if (matcher.find()) {
                            this.dYK.getText().delete(this.dYK.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dYK.getSelectionStart());
                            return;
                        }
                        this.dYK.getText().delete(this.dYK.getSelectionStart() - 1, this.dYK.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.dYK.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dYK.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.dYK.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.dYK.setSelection(VideoPlayInputContainer.this.dYK.getText().length());
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
                        this.dYK.setText((CharSequence) null);
                    }
                    this.bbL.setEnabled(false);
                    deu();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof q)) {
                        q qVar = (q) aVar.data;
                        if (qVar.aRY() == EmotionGroupType.NET_SUG) {
                            a(qVar);
                            return;
                        } else {
                            b(qVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dYK.getText().toString();
            if (this.dYh && com.baidu.tieba.face.a.Ce(obj) >= 10 && getContext() != null) {
                e.aOd().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dYK);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dYg || qVar.aRY() == EmotionGroupType.LOCAL) {
            String obj = this.dYK.getText().toString();
            if (this.dYh && com.baidu.tieba.face.a.Ce(obj) >= 10 && getContext() != null) {
                e.aOd().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dYK);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Za != null) {
            this.Za.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zb = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zb;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dYK != null) {
            this.dYK.setFocusable(true);
            this.dYK.setFocusableInTouchMode(true);
            this.dYK.requestFocus();
            l.showSoftKeyPad(getContext(), this.dYK);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.afT = i;
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dYK, R.color.cp_cont_f, 2, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.dYK, R.drawable.edittext_cursor);
            this.dYK.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.dYK, R.drawable.edittext_cursor_1);
            this.dYK.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        deu();
        am.setImageResource(this.hbn, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deu() {
        if (this.bbL.isEnabled()) {
            am.setViewTextColor(this.bbL, R.color.cp_link_tip_a, 1, this.afT);
        } else {
            am.setViewTextColor(this.bbL, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.dYK;
    }
}
