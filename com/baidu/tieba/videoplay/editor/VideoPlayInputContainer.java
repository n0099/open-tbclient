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
    private EditorTools Zt;
    private int Zu;
    private int agt;
    private TextView bjq;
    private EditText emY;
    private boolean emu;
    private boolean emv;
    private boolean emw;
    private int emx;
    private LinearLayout enc;
    private ImageView hqh;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emu = false;
        this.emv = true;
        this.emw = true;
        this.emx = -1;
        this.agt = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.enc = new LinearLayout(getContext());
        this.enc.setOrientation(0);
        this.enc.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.enc, new LinearLayout.LayoutParams(-1, -2));
        fv(context);
        dR(context);
        dQ(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fv(Context context) {
        this.hqh = new ImageView(context);
        this.hqh.setEnabled(true);
        this.hqh.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.hqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.enc.addView(this.hqh, layoutParams);
    }

    private void dR(Context context) {
        this.emY = new EditText(context);
        this.emY.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.emY.setMaxLines(4);
        this.emY.setGravity(16);
        this.emY.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.emY.setBackgroundResource(R.color.common_color_10022);
        e(this.emY, R.drawable.edittext_cursor);
        this.emY.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.emY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.emY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.emw) {
                    VideoPlayInputContainer.this.emw = true;
                    if (VideoPlayInputContainer.this.emx != -1) {
                        VideoPlayInputContainer.this.emY.setSelection(VideoPlayInputContainer.this.emx);
                        VideoPlayInputContainer.this.emx = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.emY.getText().toString()));
                }
                VideoPlayInputContainer.this.bjq.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dlH();
            }
        });
        this.emY.setHint(context.getString(R.string.reply_something));
        this.emY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.emY.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.enc.addView(this.emY, layoutParams);
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

    private void dQ(Context context) {
        this.bjq = new TextView(context);
        this.bjq.setGravity(17);
        this.bjq.setIncludeFontPadding(false);
        this.bjq.setEnabled(false);
        this.bjq.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bjq.setText(R.string.send_replay);
        this.bjq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.enc.addView(this.bjq, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.emY.getSelectionStart() > 0) {
                        String substring = this.emY.getText().toString().substring(0, this.emY.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gZq.matcher(substring);
                        if (matcher.find()) {
                            this.emY.getText().delete(this.emY.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.emY.getSelectionStart());
                            return;
                        }
                        this.emY.getText().delete(this.emY.getSelectionStart() - 1, this.emY.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.emY.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.emY.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.emY.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.emY.setSelection(VideoPlayInputContainer.this.emY.getText().length());
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
                        this.emY.setText((CharSequence) null);
                    }
                    this.bjq.setEnabled(false);
                    dlH();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof q)) {
                        q qVar = (q) aVar.data;
                        if (qVar.aYc() == EmotionGroupType.NET_SUG) {
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
            String obj = this.emY.getText().toString();
            if (this.emv && com.baidu.tieba.face.a.DQ(obj) >= 10 && getContext() != null) {
                e.aUf().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.emY);
            }
        }
    }

    private void b(q qVar) {
        if (!this.emu || qVar.aYc() == EmotionGroupType.LOCAL) {
            String obj = this.emY.getText().toString();
            if (this.emv && com.baidu.tieba.face.a.DQ(obj) >= 10 && getContext() != null) {
                e.aUf().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.emY);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.emY != null) {
            this.emY.setFocusable(true);
            this.emY.setFocusableInTouchMode(true);
            this.emY.requestFocus();
            l.showSoftKeyPad(getContext(), this.emY);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.agt = i;
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.emY, R.color.cp_cont_f, 2, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.emY, R.drawable.edittext_cursor);
            this.emY.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.emY, R.drawable.edittext_cursor_1);
            this.emY.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        dlH();
        am.setImageResource(this.hqh, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlH() {
        if (this.bjq.isEnabled()) {
            am.setViewTextColor(this.bjq, R.color.cp_link_tip_a, 1, this.agt);
        } else {
            am.setViewTextColor(this.bjq, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.emY;
    }
}
