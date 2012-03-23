package com.baidu.tieba.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ContentHelper {
    private Context mContext;
    private int mFontHeight;
    private AsyncImageLoader mImageLoader;
    private View.OnClickListener mImageOnClickListener;
    private boolean mIsEllipsized = false;
    private int mLineHeight;

    public ContentHelper(Context context) {
        this.mContext = context;
        TextView textView = new TextView(this.mContext);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(Config.getContentSize());
        this.mLineHeight = textView.getLineHeight();
        this.mFontHeight = (int) textView.getTextSize();
    }

    public void setImageLoader(AsyncImageLoader imageLoader) {
        this.mImageLoader = imageLoader;
    }

    public void setOnImageClickListener(View.OnClickListener listener) {
        this.mImageOnClickListener = listener;
    }

    public void setIsEllipsized(boolean isEllipsized) {
        this.mIsEllipsized = isEllipsized;
    }

    public void setContent(TextView textView, LinearLayout layout, List<ContentData> content, boolean isShowImage) {
        if (content != null && content.size() > 0) {
            if (this.mIsEllipsized) {
                content = getSubContent(content);
            }
            int i = 0;
            TextView textView_tmp = null;
            ContentData seg = content.get(0);
            if (seg != null && (seg.getType() == 0 || seg.getType() == 2)) {
                textView.setTextSize(Config.getContentSize());
                textView.setVisibility(0);
                setTextForView(textView, seg);
                textView_tmp = textView;
                i = 0 + 1;
            }
            if (layout != null) {
                int index = -1;
                layout.setVisibility(8);
                while (i < content.size()) {
                    layout.setVisibility(0);
                    ContentData seg2 = content.get(i);
                    if (seg2.getType() == 3) {
                        if (isShowImage) {
                            index++;
                            layout.addView(createImageView(content, seg2, index));
                            textView_tmp = null;
                        }
                    } else if (textView_tmp != null) {
                        if (seg2.getType() == 2) {
                            textView_tmp.append(seg2.getSpannableString(this.mContext, this.mLineHeight, this.mFontHeight));
                        } else {
                            textView_tmp.append(seg2.getUniteString());
                        }
                    } else {
                        TextView view = createTextView(seg2);
                        layout.addView(view);
                        textView_tmp = view;
                    }
                    i++;
                }
                return;
            }
            return;
        }
        textView.setVisibility(0);
        textView.setText((CharSequence) null);
    }

    private List<ContentData> getSubContent(List<ContentData> content) {
        List<ContentData> subList = new ArrayList<>();
        int count = 0;
        int length = content.size();
        boolean isCut = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int temp = count;
            ContentData data = content.get(i);
            int type = data.getType();
            if (type == 0 || type == 4 || type == 1) {
                if (data.getUniteString() != null) {
                    count += data.getUniteString().length();
                }
            } else {
                count++;
            }
            if (count > 50) {
                isCut = true;
                if (type == 0 || type == 4 || type == 1) {
                    SpannableStringBuilder ssb = SpannableStringBuilder.valueOf(data.getUniteString().subSequence(0, 50 - temp));
                    ContentData subData = new ContentData();
                    subData.setUniteString(ssb);
                    subData.setType(type);
                    subList.add(subData);
                }
            } else {
                subList.add(data);
                i++;
            }
        }
        if (isCut) {
            ContentData data2 = new ContentData();
            data2.setUniteString(SpannableStringBuilder.valueOf("..."));
            data2.setType(0);
            subList.add(data2);
            return subList;
        }
        return content;
    }

    private void setTextForView(TextView view, ContentData data) {
        if (view != null && data != null) {
            if (data.getType() == 2) {
                view.setText(data.getSpannableString(this.mContext, this.mLineHeight, this.mFontHeight));
            } else {
                view.setText(data.getUniteString());
            }
        }
    }

    private TextView createTextView(ContentData seg) {
        CustomTextView textView = new CustomTextView(this.mContext);
        LinearLayout.LayoutParams textViewparams = new LinearLayout.LayoutParams(-1, -2);
        int px_v = UtilHelper.dip2px(this.mContext, 15.0f);
        textViewparams.rightMargin = 0;
        textViewparams.leftMargin = 0;
        textViewparams.topMargin = px_v;
        textViewparams.bottomMargin = 0;
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(Config.getContentSize());
        textView.setTextColor(-11974584);
        setTextForView(textView, seg);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(textViewparams);
        return textView;
    }

    private ImageView createImageView(List<ContentData> content, ContentData seg, int index) {
        ImageView imageView = new ImageView(this.mContext);
        int height = UtilHelper.dip2px(this.mContext, 120.0f);
        int width = UtilHelper.dip2px(this.mContext, 150.0f);
        LinearLayout.LayoutParams imageViewparams = new LinearLayout.LayoutParams(-2, height);
        int px_v = UtilHelper.dip2px(this.mContext, 15.0f);
        imageViewparams.topMargin = px_v;
        imageViewparams.bottomMargin = 0;
        Bitmap image = this.mImageLoader.getPic(seg.getLink());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setMaxWidth(width);
        if (image != null) {
            imageView.setTag(null);
            imageView.setImageBitmap(image);
        } else {
            imageView.setTag(seg.getLink());
            Bitmap bm = BitmapHelper.getCashBitmap(R.drawable.image_default);
            imageView.setImageBitmap(bm);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.mImageOnClickListener);
        imageView.setLayoutParams(imageViewparams);
        return imageView;
    }
}
