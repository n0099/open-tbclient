package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
/* loaded from: classes5.dex */
public final class DrawableDecoderCompat {
    public static volatile boolean shouldCallAppCompatResources = true;

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i2) {
        return getDrawable(context, context2, i2, null);
    }

    public static Drawable loadDrawableV4(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i2, theme);
    }

    public static Drawable loadDrawableV7(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i2);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return getDrawable(context, context, i2, theme);
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i2, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i2);
            }
            throw e2;
        } catch (NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i2, theme);
    }
}
