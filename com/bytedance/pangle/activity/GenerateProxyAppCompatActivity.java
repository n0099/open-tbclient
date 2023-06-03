package com.bytedance.pangle.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.PersistableBundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.pangle.plugin.Plugin;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;
@Keep
/* loaded from: classes9.dex */
public abstract class GenerateProxyAppCompatActivity extends AppCompatActivity implements b {
    public Plugin mPlugin;
    public GeneratePluginAppCompatActivity mTargetActivity;

    @Override // com.bytedance.pangle.activity.b
    public abstract String getPluginPkgName();

    @Override // android.app.Activity
    public void closeContextMenu() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void closeOptionsMenu() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.enterPictureInPictureMode();
        } else {
            super.enterPictureInPictureMode();
        }
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public void finish() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishAffinity();
        } else {
            super.finishAffinity();
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishAfterTransition();
        } else {
            super.finishAfterTransition();
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishAndRemoveTask();
        } else {
            super.finishAndRemoveTask();
        }
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getActionBar();
        }
        return super.getActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getCallingActivity();
        }
        return super.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getCallingPackage();
        }
        return super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getChangingConfigurations();
        }
        return super.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getComponentName();
        }
        return super.getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getContentScene();
        }
        return super.getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getContentTransitionManager();
        }
        return super.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getCurrentFocus();
        }
        return super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getFragmentManager();
        }
        return super.getFragmentManager();
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public Intent getIntent() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getIntent();
        }
        return super.getIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getLastNonConfigurationInstance();
        }
        return super.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getLayoutInflater();
        }
        return super.getLayoutInflater();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getLifecycle();
        }
        return super.getLifecycle();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getLoaderManager();
        }
        return super.getLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getLocalClassName();
        }
        return super.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getMaxNumPictureInPictureActions();
        }
        return super.getMaxNumPictureInPictureActions();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public MenuInflater getMenuInflater() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getMenuInflater();
        }
        return super.getMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getParentActivityIntent();
        }
        return super.getParentActivityIntent();
    }

    @Override // com.bytedance.pangle.activity.b
    public Plugin getPlugin() {
        return this.mPlugin;
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getReferrer();
        }
        return super.getReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getRequestedOrientation();
        }
        return super.getRequestedOrientation();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public androidx.appcompat.app.ActionBar getSupportActionBar() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getSupportActionBar();
        }
        return super.getSupportActionBar();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getSupportFragmentManager();
        }
        return super.getSupportFragmentManager();
    }

    @Override // android.app.Activity
    public int getTaskId() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getTaskId();
        }
        return super.getTaskId();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getVoiceInteractor();
        }
        return super.getVoiceInteractor();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getWindow();
        }
        return super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getWindowManager();
        }
        return super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.hasWindowFocus();
        }
        return super.hasWindowFocus();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void invalidateOptionsMenu() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.invalidateOptionsMenu();
        } else {
            super.invalidateOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isActivityTransitionRunning();
        }
        return super.isActivityTransitionRunning();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isChangingConfigurations();
        }
        return super.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isDestroyed();
        }
        return super.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isFinishing();
        }
        return super.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isImmersive();
        }
        return super.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isInMultiWindowMode();
        }
        return super.isInMultiWindowMode();
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isInPictureInPictureMode();
        }
        return super.isInPictureInPictureMode();
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isLocalVoiceInteractionSupported();
        }
        return super.isLocalVoiceInteractionSupported();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isTaskRoot();
        }
        return super.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isVoiceInteraction();
        }
        return super.isVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.isVoiceInteractionRoot();
        }
        return super.isVoiceInteractionRoot();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateDescription();
        }
        return super.onCreateDescription();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onEnterAnimationComplete();
        } else {
            super.onEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onLocalVoiceInteractionStarted();
        } else {
            super.onLocalVoiceInteractionStarted();
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onLocalVoiceInteractionStopped();
        } else {
            super.onLocalVoiceInteractionStopped();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onNavigateUp();
        }
        return super.onNavigateUp();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onPictureInPictureRequested();
        }
        return super.onPictureInPictureRequested();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPostResume();
        } else {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onProvideReferrer();
        }
        return super.onProvideReferrer();
    }

    @Override // android.app.Activity
    public void onRestart() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onRestart();
        } else {
            super.onRestart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onResume();
        } else {
            super.onResume();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onSearchRequested();
        }
        return super.onSearchRequested();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onStart();
        } else {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onStateNotSaved();
        } else {
            super.onStateNotSaved();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onStop();
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onUserLeaveHint();
        } else {
            super.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onVisibleBehindCanceled();
        } else {
            super.onVisibleBehindCanceled();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void openOptionsMenu() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.postponeEnterTransition();
        } else {
            super.postponeEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.recreate();
        } else {
            super.recreate();
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.releaseInstance();
        }
        return super.releaseInstance();
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.reportFullyDrawn();
        } else {
            super.reportFullyDrawn();
        }
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.showLockTaskEscapeMessage();
        } else {
            super.showLockTaskEscapeMessage();
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startLockTask();
        } else {
            super.startLockTask();
        }
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startPostponedEnterTransition();
        } else {
            super.startPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.stopLocalVoiceInteraction();
        } else {
            super.stopLocalVoiceInteraction();
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.stopLockTask();
        } else {
            super.stopLockTask();
        }
    }

    public void zeusSuperCloseContextMenu() {
        super.closeContextMenu();
    }

    public void zeusSuperCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    public void zeusSuperEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    public void zeusSuperFinish() {
        super.finish();
    }

    public void zeusSuperFinishAffinity() {
        super.finishAffinity();
    }

    public void zeusSuperFinishAfterTransition() {
        super.finishAfterTransition();
    }

    public void zeusSuperFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    public ActionBar zeusSuperGetActionBar() {
        return super.getActionBar();
    }

    public ComponentName zeusSuperGetCallingActivity() {
        return super.getCallingActivity();
    }

    public String zeusSuperGetCallingPackage() {
        return super.getCallingPackage();
    }

    public int zeusSuperGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public ComponentName zeusSuperGetComponentName() {
        return super.getComponentName();
    }

    public Scene zeusSuperGetContentScene() {
        return super.getContentScene();
    }

    public TransitionManager zeusSuperGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    public View zeusSuperGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    public FragmentManager zeusSuperGetFragmentManager() {
        return super.getFragmentManager();
    }

    public Intent zeusSuperGetIntent() {
        return super.getIntent();
    }

    public Object zeusSuperGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    public LayoutInflater zeusSuperGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    public Lifecycle zeusSuperGetLifecycle() {
        return super.getLifecycle();
    }

    public LoaderManager zeusSuperGetLoaderManager() {
        return super.getLoaderManager();
    }

    public String zeusSuperGetLocalClassName() {
        return super.getLocalClassName();
    }

    public int zeusSuperGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }

    public MenuInflater zeusSuperGetMenuInflater() {
        return super.getMenuInflater();
    }

    public Intent zeusSuperGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    public Uri zeusSuperGetReferrer() {
        return super.getReferrer();
    }

    public int zeusSuperGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    public androidx.appcompat.app.ActionBar zeusSuperGetSupportActionBar() {
        return super.getSupportActionBar();
    }

    public androidx.fragment.app.FragmentManager zeusSuperGetSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    public int zeusSuperGetTaskId() {
        return super.getTaskId();
    }

    public VoiceInteractor zeusSuperGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    public Window zeusSuperGetWindow() {
        return super.getWindow();
    }

    public WindowManager zeusSuperGetWindowManager() {
        return super.getWindowManager();
    }

    public boolean zeusSuperHasWindowFocus() {
        return super.hasWindowFocus();
    }

    public void zeusSuperInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    public boolean zeusSuperIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }

    public boolean zeusSuperIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    public boolean zeusSuperIsDestroyed() {
        return super.isDestroyed();
    }

    public boolean zeusSuperIsFinishing() {
        return super.isFinishing();
    }

    public boolean zeusSuperIsImmersive() {
        return super.isImmersive();
    }

    public boolean zeusSuperIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    public boolean zeusSuperIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    public boolean zeusSuperIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    public boolean zeusSuperIsTaskRoot() {
        return super.isTaskRoot();
    }

    public boolean zeusSuperIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    public boolean zeusSuperIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    public void zeusSuperOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void zeusSuperOnBackPressed() {
        super.onBackPressed();
    }

    public void zeusSuperOnContentChanged() {
        super.onContentChanged();
    }

    public CharSequence zeusSuperOnCreateDescription() {
        return super.onCreateDescription();
    }

    public void zeusSuperOnDestroy() {
        super.onDestroy();
    }

    public void zeusSuperOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void zeusSuperOnEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    public void zeusSuperOnLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    public void zeusSuperOnLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    public void zeusSuperOnLowMemory() {
        super.onLowMemory();
    }

    public boolean zeusSuperOnNavigateUp() {
        return super.onNavigateUp();
    }

    public void zeusSuperOnPause() {
        super.onPause();
    }

    public boolean zeusSuperOnPictureInPictureRequested() {
        return super.onPictureInPictureRequested();
    }

    public void zeusSuperOnPostResume() {
        super.onPostResume();
    }

    public Uri zeusSuperOnProvideReferrer() {
        return super.onProvideReferrer();
    }

    public void zeusSuperOnRestart() {
        super.onRestart();
    }

    public void zeusSuperOnResume() {
        super.onResume();
    }

    public boolean zeusSuperOnSearchRequested() {
        return super.onSearchRequested();
    }

    public void zeusSuperOnStart() {
        super.onStart();
    }

    public void zeusSuperOnStateNotSaved() {
        super.onStateNotSaved();
    }

    public void zeusSuperOnStop() {
        super.onStop();
    }

    public void zeusSuperOnUserInteraction() {
        super.onUserInteraction();
    }

    public void zeusSuperOnUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public void zeusSuperOnVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    public void zeusSuperOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    public void zeusSuperPostponeEnterTransition() {
        super.postponeEnterTransition();
    }

    public void zeusSuperRecreate() {
        super.recreate();
    }

    public boolean zeusSuperReleaseInstance() {
        return super.releaseInstance();
    }

    public void zeusSuperReportFullyDrawn() {
        super.reportFullyDrawn();
    }

    public void zeusSuperShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    public void zeusSuperStartLockTask() {
        super.startLockTask();
    }

    public void zeusSuperStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    public void zeusSuperStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    public void zeusSuperStopLockTask() {
        super.stopLockTask();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void addContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.addContentView(view2, layoutParams);
        } else {
            super.addContentView(view2, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishActivityFromChild(activity, i);
        } else {
            super.finishActivityFromChild(activity, i);
        }
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.navigateUpToFromChild(activity, intent);
        }
        return super.navigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i, Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onActivityReenter(i, intent);
        } else {
            super.onActivityReenter(i, intent);
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onChildTitleChanged(activity, charSequence);
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onCreate(bundle, persistableBundle);
        } else {
            super.onCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateDialog(i, bundle);
        }
        return super.onCreateDialog(i, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreatePanelMenu(i, menu);
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateThumbnail(bitmap, canvas);
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onGetDirectActions(cancellationSignal, consumer);
        } else {
            super.onGetDirectActions(cancellationSignal, consumer);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onKeyLongPress(i, keyEvent);
        }
        return super.onKeyLongPress(i, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onKeyShortcut(i, keyEvent);
        }
        return super.onKeyShortcut(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onMenuOpened(i, menu);
        }
        return super.onMenuOpened(i, menu);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onMultiWindowModeChanged(z, configuration);
        } else {
            super.onMultiWindowModeChanged(z, configuration);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPanelClosed(i, menu);
        } else {
            super.onPanelClosed(i, menu);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPictureInPictureModeChanged(z, configuration);
        } else {
            super.onPictureInPictureModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPostCreate(bundle, persistableBundle);
        } else {
            super.onPostCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPrepareDialog(i, dialog);
        } else {
            super.onPrepareDialog(i, dialog);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onRestoreInstanceState(bundle, persistableBundle);
        } else {
            super.onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onSaveInstanceState(bundle, persistableBundle);
        } else {
            super.onSaveInstanceState(bundle, persistableBundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onTitleChanged(charSequence, i);
        } else {
            super.onTitleChanged(charSequence, i);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onWindowStartingActionMode(callback, i);
        }
        return super.onWindowStartingActionMode(callback, i);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.overridePendingTransition(i, i2);
        } else {
            super.overridePendingTransition(i, i2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setContentView(view2, layoutParams);
        } else {
            super.setContentView(view2, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setLocusContext(locusId, bundle);
        } else {
            super.setLocusContext(locusId, bundle);
        }
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setVrModeEnabled(z, componentName);
        } else {
            super.setVrModeEnabled(z, componentName);
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startActionMode(callback, i);
        }
        return super.startActionMode(callback, i);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivities(intentArr, bundle);
        } else {
            super.startActivities(intentArr, bundle);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivity(intent, bundle);
        } else {
            super.startActivity(intent, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityForResult(intent, i);
        } else {
            super.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startActivityIfNeeded(intent, i);
        }
        return super.startActivityIfNeeded(intent, i);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startNextMatchingActivity(intent, bundle);
        }
        return super.startNextMatchingActivity(intent, bundle);
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.triggerSearch(str, bundle);
        } else {
            super.triggerSearch(str, bundle);
        }
    }

    public void zeusSuperAddContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view2, layoutParams);
    }

    public boolean zeusSuperConvertToTranslucent(Activity.TranslucentConversionListener translucentConversionListener, ActivityOptions activityOptions) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", Class.forName("android.app.Activity$TranslucentConversionListener"), ActivityOptions.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(this, translucentConversionListener, activityOptions)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void zeusSuperFinishActivityFromChild(Activity activity, int i) {
        super.finishActivityFromChild(activity, i);
    }

    public boolean zeusSuperNavigateUpToFromChild(Activity activity, Intent intent) {
        return super.navigateUpToFromChild(activity, intent);
    }

    public void zeusSuperOnActivityReenter(int i, Intent intent) {
        super.onActivityReenter(i, intent);
    }

    public void zeusSuperOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    public void zeusSuperOnCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    public Dialog zeusSuperOnCreateDialog(int i, Bundle bundle) {
        return super.onCreateDialog(i, bundle);
    }

    public boolean zeusSuperOnCreatePanelMenu(int i, Menu menu) {
        return super.onCreatePanelMenu(i, menu);
    }

    public boolean zeusSuperOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    public void zeusSuperOnGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        super.onGetDirectActions(cancellationSignal, consumer);
    }

    public boolean zeusSuperOnKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public boolean zeusSuperOnKeyLongPress(int i, KeyEvent keyEvent) {
        return super.onKeyLongPress(i, keyEvent);
    }

    public boolean zeusSuperOnKeyShortcut(int i, KeyEvent keyEvent) {
        return super.onKeyShortcut(i, keyEvent);
    }

    public boolean zeusSuperOnKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    public boolean zeusSuperOnMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
    }

    public void zeusSuperOnPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z, Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
    }

    public void zeusSuperOnPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onPostCreate(bundle, persistableBundle);
    }

    public void zeusSuperOnPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
    }

    public void zeusSuperOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
    }

    public void zeusSuperOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    public void zeusSuperOnTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return super.onWindowStartingActionMode(callback, i);
    }

    public void zeusSuperOverridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
    }

    public void zeusSuperSetContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view2, layoutParams);
    }

    public void zeusSuperSetLocusContext(LocusId locusId, Bundle bundle) {
        super.setLocusContext(locusId, bundle);
    }

    public void zeusSuperSetVrModeEnabled(boolean z, ComponentName componentName) {
        super.setVrModeEnabled(z, componentName);
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback, int i) {
        return super.startActionMode(callback, i);
    }

    public void zeusSuperStartActivities(Intent[] intentArr, Bundle bundle) {
        super.startActivities(intentArr, bundle);
    }

    public void zeusSuperStartActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i) {
        return super.startActivityIfNeeded(intent, i);
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent, Bundle bundle) {
        return super.startNextMatchingActivity(intent, bundle);
    }

    public void zeusSuperTriggerSearch(String str, Bundle bundle) {
        super.triggerSearch(str, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        c.a(this, context);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.dispatchGenericMotionEvent(motionEvent);
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.dispatchKeyShortcutEvent(keyEvent);
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.dispatchTrackballEvent(motionEvent);
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.enterPictureInPictureMode(pictureInPictureParams);
        }
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.findViewById(i);
        }
        return super.findViewById(i);
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishActivity(i);
        } else {
            super.finishActivity(i);
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.finishFromChild(activity);
        } else {
            super.finishFromChild(activity);
        }
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getPreferences(i);
        }
        return super.getPreferences(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.getSystemService(str);
        }
        return super.getSystemService(str);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.moveTaskToBack(z);
        }
        return super.moveTaskToBack(z);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.navigateUpTo(intent);
        }
        return super.navigateUpTo(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onActionModeFinished(actionMode);
        } else {
            super.onActionModeFinished(actionMode);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onActionModeStarted(actionMode);
        } else {
            super.onActionModeStarted(actionMode);
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onAttachFragment(fragment);
        } else {
            super.onAttachFragment(fragment);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onContextItemSelected(menuItem);
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        c.a(this, bundle);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateDialog(i);
        }
        return super.onCreateDialog(i);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateOptionsMenu(menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreatePanelView(i);
        }
        return super.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onGenericMotionEvent(motionEvent);
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onMultiWindowModeChanged(z);
        } else {
            super.onMultiWindowModeChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onNavigateUpFromChild(activity);
        }
        return super.onNavigateUpFromChild(activity);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onOptionsItemSelected(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPictureInPictureModeChanged(z);
        } else {
            super.onPictureInPictureModeChanged(z);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPostCreate(bundle);
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onPrepareOptionsMenu(menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onProvideAssistContent(assistContent);
        } else {
            super.onProvideAssistContent(assistContent);
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onProvideAssistData(bundle);
        } else {
            super.onProvideAssistData(bundle);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onRestoreInstanceState(bundle);
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onSaveInstanceState(bundle);
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onSearchRequested(searchEvent);
        }
        return super.onSearchRequested(searchEvent);
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onTopResumedActivityChanged(z);
        } else {
            super.onTopResumedActivityChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onTrackballEvent(motionEvent);
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onTrimMemory(i);
        } else {
            super.onTrimMemory(i);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onWindowStartingActionMode(callback);
        }
        return super.onWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity
    public void openContextMenu(View view2) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.openContextMenu(view2);
        } else {
            super.openContextMenu(view2);
        }
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view2) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.registerForContextMenu(view2);
        } else {
            super.registerForContextMenu(view2);
        }
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.requestDragAndDropPermissions(dragEvent);
        }
        return super.requestDragAndDropPermissions(dragEvent);
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.requestVisibleBehind(z);
        }
        return super.requestVisibleBehind(z);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setActionBar(toolbar);
        } else {
            super.setActionBar(toolbar);
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setContentTransitionManager(transitionManager);
        } else {
            super.setContentTransitionManager(transitionManager);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setContentView(i);
        } else {
            super.setContentView(i);
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setEnterSharedElementCallback(sharedElementCallback);
        } else {
            super.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setExitSharedElementCallback(sharedElementCallback);
        } else {
            super.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setFinishOnTouchOutside(z);
        } else {
            super.setFinishOnTouchOutside(z);
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setImmersive(z);
        } else {
            super.setImmersive(z);
        }
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setInheritShowWhenLocked(z);
        } else {
            super.setInheritShowWhenLocked(z);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setIntent(intent);
        } else {
            super.setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setPictureInPictureParams(pictureInPictureParams);
        } else {
            super.setPictureInPictureParams(pictureInPictureParams);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setPlugin(Plugin plugin) {
        this.mPlugin = plugin;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setRequestedOrientation(i);
        } else {
            super.setRequestedOrientation(i);
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setShowWhenLocked(z);
        } else {
            super.setShowWhenLocked(z);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setTargetActivity(IPluginActivity iPluginActivity) {
        this.mTargetActivity = (GeneratePluginAppCompatActivity) iPluginActivity;
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTaskDescription(taskDescription);
        } else {
            super.setTaskDescription(taskDescription);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTheme(i);
        } else {
            super.setTheme(i);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTitle(i);
        } else {
            super.setTitle(i);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTitleColor(i);
        } else {
            super.setTitleColor(i);
        }
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.setTranslucent(z);
        }
        return super.setTranslucent(z);
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTurnScreenOn(z);
        } else {
            super.setTurnScreenOn(z);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setVisible(z);
        } else {
            super.setVisible(z);
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.shouldShowRequestPermissionRationale(str);
        }
        return super.shouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.shouldUpRecreateTask(intent);
        }
        return super.shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.showAssist(bundle);
        }
        return super.showAssist(bundle);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startActionMode(callback);
        }
        return super.startActionMode(callback);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivities(intentArr);
        } else {
            super.startActivities(intentArr);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startLocalVoiceInteraction(bundle);
        } else {
            super.startLocalVoiceInteraction(bundle);
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startManagingCursor(cursor);
        } else {
            super.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startNextMatchingActivity(intent);
        }
        return super.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.stopManagingCursor(cursor);
        } else {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.takeKeyEvents(z);
        } else {
            super.takeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view2) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.unregisterForContextMenu(view2);
        } else {
            super.unregisterForContextMenu(view2);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperAttachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public boolean zeusSuperDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean zeusSuperDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean zeusSuperDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean zeusSuperDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean zeusSuperDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean zeusSuperDispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    public boolean zeusSuperEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    public View zeusSuperFindViewById(int i) {
        return super.findViewById(i);
    }

    public void zeusSuperFinishActivity(int i) {
        super.finishActivity(i);
    }

    public void zeusSuperFinishFromChild(Activity activity) {
        super.finishFromChild(activity);
    }

    public SharedPreferences zeusSuperGetPreferences(int i) {
        return super.getPreferences(i);
    }

    public Object zeusSuperGetSystemService(String str) {
        return super.getSystemService(str);
    }

    public boolean zeusSuperMoveTaskToBack(boolean z) {
        return super.moveTaskToBack(z);
    }

    public boolean zeusSuperNavigateUpTo(Intent intent) {
        return super.navigateUpTo(intent);
    }

    public void zeusSuperOnActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
    }

    public void zeusSuperOnActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    public void zeusSuperOnAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public void zeusSuperOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public boolean zeusSuperOnContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public void zeusSuperOnContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog zeusSuperOnCreateDialog(int i) {
        return super.onCreateDialog(i);
    }

    public void zeusSuperOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    public boolean zeusSuperOnCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public View zeusSuperOnCreatePanelView(int i) {
        return super.onCreatePanelView(i);
    }

    public boolean zeusSuperOnGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
    }

    public boolean zeusSuperOnNavigateUpFromChild(Activity activity) {
        return super.onNavigateUpFromChild(activity);
    }

    public void zeusSuperOnNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public boolean zeusSuperOnOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void zeusSuperOnOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
    }

    public void zeusSuperOnPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    public void zeusSuperOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    public boolean zeusSuperOnPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public void zeusSuperOnProvideAssistContent(AssistContent assistContent) {
        super.onProvideAssistContent(assistContent);
    }

    public void zeusSuperOnProvideAssistData(Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    public void zeusSuperOnRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    public void zeusSuperOnSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public boolean zeusSuperOnSearchRequested(SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    public void zeusSuperOnTopResumedActivityChanged(boolean z) {
        super.onTopResumedActivityChanged(z);
    }

    public boolean zeusSuperOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean zeusSuperOnTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    public void zeusSuperOnTrimMemory(int i) {
        super.onTrimMemory(i);
    }

    public void zeusSuperOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    public void zeusSuperOnWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    public void zeusSuperOpenContextMenu(View view2) {
        super.openContextMenu(view2);
    }

    public void zeusSuperRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void zeusSuperRegisterForContextMenu(View view2) {
        super.registerForContextMenu(view2);
    }

    public DragAndDropPermissions zeusSuperRequestDragAndDropPermissions(DragEvent dragEvent) {
        return super.requestDragAndDropPermissions(dragEvent);
    }

    public boolean zeusSuperRequestVisibleBehind(boolean z) {
        return super.requestVisibleBehind(z);
    }

    public void zeusSuperSetActionBar(Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    public void zeusSuperSetContentTransitionManager(TransitionManager transitionManager) {
        super.setContentTransitionManager(transitionManager);
    }

    public void zeusSuperSetContentView(int i) {
        super.setContentView(i);
    }

    public void zeusSuperSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setEnterSharedElementCallback(sharedElementCallback);
    }

    public void zeusSuperSetExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setExitSharedElementCallback(sharedElementCallback);
    }

    public void zeusSuperSetFinishOnTouchOutside(boolean z) {
        super.setFinishOnTouchOutside(z);
    }

    public void zeusSuperSetImmersive(boolean z) {
        super.setImmersive(z);
    }

    public void zeusSuperSetInheritShowWhenLocked(boolean z) {
        super.setInheritShowWhenLocked(z);
    }

    public void zeusSuperSetIntent(Intent intent) {
        super.setIntent(intent);
    }

    public void zeusSuperSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        super.setPictureInPictureParams(pictureInPictureParams);
    }

    public void zeusSuperSetRequestedOrientation(int i) {
        super.setRequestedOrientation(i);
    }

    public void zeusSuperSetShowWhenLocked(boolean z) {
        super.setShowWhenLocked(z);
    }

    public void zeusSuperSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperSetTheme(int i) {
        super.setTheme(i);
    }

    public void zeusSuperSetTitle(int i) {
        super.setTitle(i);
    }

    public void zeusSuperSetTitleColor(int i) {
        super.setTitleColor(i);
    }

    public boolean zeusSuperSetTranslucent(boolean z) {
        return super.setTranslucent(z);
    }

    public void zeusSuperSetTurnScreenOn(boolean z) {
        super.setTurnScreenOn(z);
    }

    public void zeusSuperSetVisible(boolean z) {
        super.setVisible(z);
    }

    public boolean zeusSuperShouldShowRequestPermissionRationale(String str) {
        return super.shouldShowRequestPermissionRationale(str);
    }

    public boolean zeusSuperShouldUpRecreateTask(Intent intent) {
        return super.shouldUpRecreateTask(intent);
    }

    public boolean zeusSuperShowAssist(Bundle bundle) {
        return super.showAssist(bundle);
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    public void zeusSuperStartActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
    }

    public void zeusSuperStartActivity(Intent intent) {
        super.startActivity(intent);
    }

    public void zeusSuperStartLocalVoiceInteraction(Bundle bundle) {
        super.startLocalVoiceInteraction(bundle);
    }

    public void zeusSuperStartManagingCursor(Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    public void zeusSuperStopManagingCursor(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    public void zeusSuperTakeKeyEvents(boolean z) {
        super.takeKeyEvents(z);
    }

    public void zeusSuperUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void zeusSuperUnregisterForContextMenu(View view2) {
        super.unregisterForContextMenu(view2);
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.createPendingResult(i, intent, i2);
        }
        return super.createPendingResult(i, intent, i2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onActivityResult(i, i2, intent);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onApplyThemeResource(theme, i, z);
        } else {
            super.onApplyThemeResource(theme, i, z);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateView(str, context, attributeSet);
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onKeyMultiple(i, i2, keyEvent);
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPrepareDialog(i, dialog, bundle);
        } else {
            super.onPrepareDialog(i, dialog, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view2, Menu menu) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onPreparePanel(i, view2, menu);
        }
        return super.onPreparePanel(i, view2, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onProvideKeyboardShortcuts(list, menu, i);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onRequestPermissionsResult(i, strArr, iArr);
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityForResult(intent, i, bundle);
        } else {
            super.startActivityForResult(intent, i, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityFromChild(activity, intent, i);
        } else {
            super.startActivityFromChild(activity, intent, i);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityFromFragment(fragment, intent, i);
        } else {
            super.startActivityFromFragment(fragment, intent, i);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.startActivityIfNeeded(intent, i, bundle);
        }
        return super.startActivityIfNeeded(intent, i, bundle);
    }

    public PendingIntent zeusSuperCreatePendingResult(int i, Intent intent, int i2) {
        return super.createPendingResult(i, intent, i2);
    }

    public void zeusSuperOnActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void zeusSuperOnApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        super.onApplyThemeResource(theme, i, z);
    }

    public void zeusSuperOnCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
    }

    public View zeusSuperOnCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public boolean zeusSuperOnKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    public void zeusSuperOnPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i, dialog, bundle);
    }

    public boolean zeusSuperOnPreparePanel(int i, View view2, Menu menu) {
        return super.onPreparePanel(i, view2, menu);
    }

    public void zeusSuperOnProvideKeyboardShortcuts(List list, Menu menu, int i) {
        super.onProvideKeyboardShortcuts(list, menu, i);
    }

    public void zeusSuperOnRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i) {
        super.startActivityFromChild(activity, intent, i);
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        super.startActivityFromFragment(fragment, intent, i);
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        return super.startActivityIfNeeded(intent, i, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.dump(str, fileDescriptor, printWriter, strArr);
        } else {
            super.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            return generatePluginAppCompatActivity.onCreateView(view2, str, context, attributeSet);
        }
        return super.onCreateView(view2, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        } else {
            super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityFromChild(activity, intent, i, bundle);
        } else {
            super.startActivityFromChild(activity, intent, i, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startActivityFromFragment(fragment, intent, i, bundle);
        } else {
            super.startActivityFromFragment(fragment, intent, i, bundle);
        }
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startSearch(str, z, bundle, z2);
        } else {
            super.startSearch(str, z, bundle, z2);
        }
    }

    public void zeusSuperDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
    }

    public View zeusSuperOnCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view2, str, context, attributeSet);
    }

    public void zeusSuperOnPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i, Bundle bundle) {
        super.startActivityFromChild(activity, intent, i, bundle);
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i, bundle);
    }

    public void zeusSuperStartSearch(String str, boolean z, Bundle bundle, boolean z2) {
        super.startSearch(str, z, bundle, z2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view2) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setContentView(view2);
        } else {
            super.setContentView(view2);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    public void zeusSuperSetContentView(View view2) {
        super.setContentView(view2);
    }

    public void zeusSuperSetTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSender(intentSender, intent, i, i2, i3);
        } else {
            super.startIntentSender(intentSender, intent, i, i2, i3);
        }
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        super.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSender(intentSender, intent, i, i2, i3, bundle);
        } else {
            super.startIntentSender(intentSender, intent, i, i2, i3, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        } else {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) {
        super.startIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
        } else {
            super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
        }
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
        if (generatePluginAppCompatActivity != null) {
            generatePluginAppCompatActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
    }
}
