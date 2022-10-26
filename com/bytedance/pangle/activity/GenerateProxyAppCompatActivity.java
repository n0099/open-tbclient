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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.plugin.Plugin;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;
/* loaded from: classes7.dex */
public abstract class GenerateProxyAppCompatActivity extends AppCompatActivity implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Plugin mPlugin;
    public GeneratePluginAppCompatActivity mTargetActivity;

    @Override // com.bytedance.pangle.activity.b
    public abstract String getPluginPkgName();

    public GenerateProxyAppCompatActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.closeContextMenu();
            } else {
                super.closeContextMenu();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void closeOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.closeOptionsMenu();
            } else {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.enterPictureInPictureMode();
            } else {
                super.enterPictureInPictureMode();
            }
        }
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.finish();
            } else {
                super.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.finishAffinity();
            } else {
                super.finishAffinity();
            }
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.finishAfterTransition();
            } else {
                super.finishAfterTransition();
            }
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.finishAndRemoveTask();
            } else {
                super.finishAndRemoveTask();
            }
        }
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getActionBar();
            }
            return super.getActionBar();
        }
        return (ActionBar) invokeV.objValue;
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getCallingActivity();
            }
            return super.getCallingActivity();
        }
        return (ComponentName) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getCallingPackage();
            }
            return super.getCallingPackage();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getChangingConfigurations();
            }
            return super.getChangingConfigurations();
        }
        return invokeV.intValue;
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getComponentName();
            }
            return super.getComponentName();
        }
        return (ComponentName) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getContentScene();
            }
            return super.getContentScene();
        }
        return (Scene) invokeV.objValue;
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getContentTransitionManager();
            }
            return super.getContentTransitionManager();
        }
        return (TransitionManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getCurrentFocus();
            }
            return super.getCurrentFocus();
        }
        return (View) invokeV.objValue;
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getFragmentManager();
            }
            return super.getFragmentManager();
        }
        return (FragmentManager) invokeV.objValue;
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getIntent();
            }
            return super.getIntent();
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getLastNonConfigurationInstance();
            }
            return super.getLastNonConfigurationInstance();
        }
        return invokeV.objValue;
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getLayoutInflater();
            }
            return super.getLayoutInflater();
        }
        return (LayoutInflater) invokeV.objValue;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getLifecycle();
            }
            return super.getLifecycle();
        }
        return (Lifecycle) invokeV.objValue;
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getLoaderManager();
            }
            return super.getLoaderManager();
        }
        return (LoaderManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getLocalClassName();
            }
            return super.getLocalClassName();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getMaxNumPictureInPictureActions();
            }
            return super.getMaxNumPictureInPictureActions();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getMenuInflater();
            }
            return super.getMenuInflater();
        }
        return (MenuInflater) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getParentActivityIntent();
            }
            return super.getParentActivityIntent();
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.bytedance.pangle.activity.b
    public Plugin getPlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mPlugin;
        }
        return (Plugin) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getReferrer();
            }
            return super.getReferrer();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getRequestedOrientation();
            }
            return super.getRequestedOrientation();
        }
        return invokeV.intValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public androidx.appcompat.app.ActionBar getSupportActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getSupportActionBar();
            }
            return super.getSupportActionBar();
        }
        return (androidx.appcompat.app.ActionBar) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getSupportFragmentManager();
            }
            return super.getSupportFragmentManager();
        }
        return (androidx.fragment.app.FragmentManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getTaskId();
            }
            return super.getTaskId();
        }
        return invokeV.intValue;
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getVoiceInteractor();
            }
            return super.getVoiceInteractor();
        }
        return (VoiceInteractor) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getWindow();
            }
            return super.getWindow();
        }
        return (Window) invokeV.objValue;
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getWindowManager();
            }
            return super.getWindowManager();
        }
        return (WindowManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.hasWindowFocus();
            }
            return super.hasWindowFocus();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void invalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.invalidateOptionsMenu();
            } else {
                super.invalidateOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isActivityTransitionRunning();
            }
            return super.isActivityTransitionRunning();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isChangingConfigurations();
            }
            return super.isChangingConfigurations();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isDestroyed();
            }
            return super.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isFinishing();
            }
            return super.isFinishing();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isImmersive();
            }
            return super.isImmersive();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isInMultiWindowMode();
            }
            return super.isInMultiWindowMode();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isInPictureInPictureMode();
            }
            return super.isInPictureInPictureMode();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isLocalVoiceInteractionSupported();
            }
            return super.isLocalVoiceInteractionSupported();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isTaskRoot();
            }
            return super.isTaskRoot();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isVoiceInteraction();
            }
            return super.isVoiceInteraction();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.isVoiceInteractionRoot();
            }
            return super.isVoiceInteractionRoot();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onAttachedToWindow();
            } else {
                super.onAttachedToWindow();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onBackPressed();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onContentChanged();
            } else {
                super.onContentChanged();
            }
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreateDescription();
            }
            return super.onCreateDescription();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onDestroy();
            } else {
                super.onDestroy();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onDetachedFromWindow();
            } else {
                super.onDetachedFromWindow();
            }
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onEnterAnimationComplete();
            } else {
                super.onEnterAnimationComplete();
            }
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onLocalVoiceInteractionStarted();
            } else {
                super.onLocalVoiceInteractionStarted();
            }
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onLocalVoiceInteractionStopped();
            } else {
                super.onLocalVoiceInteractionStopped();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onLowMemory();
            } else {
                super.onLowMemory();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onNavigateUp();
            }
            return super.onNavigateUp();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPause();
            } else {
                super.onPause();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onPictureInPictureRequested();
            }
            return super.onPictureInPictureRequested();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPostResume();
            } else {
                super.onPostResume();
            }
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onProvideReferrer();
            }
            return super.onProvideReferrer();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onRestart();
            } else {
                super.onRestart();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onResume();
            } else {
                super.onResume();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onSearchRequested();
            }
            return super.onSearchRequested();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onStart();
            } else {
                super.onStart();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onStateNotSaved();
            } else {
                super.onStateNotSaved();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onStop();
            } else {
                super.onStop();
            }
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onUserInteraction();
            } else {
                super.onUserInteraction();
            }
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onUserLeaveHint();
            } else {
                super.onUserLeaveHint();
            }
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onVisibleBehindCanceled();
            } else {
                super.onVisibleBehindCanceled();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void openOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.openOptionsMenu();
            } else {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.postponeEnterTransition();
            } else {
                super.postponeEnterTransition();
            }
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048737, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.recreate();
            } else {
                super.recreate();
            }
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.releaseInstance();
            }
            return super.releaseInstance();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.reportFullyDrawn();
            } else {
                super.reportFullyDrawn();
            }
        }
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.showLockTaskEscapeMessage();
            } else {
                super.showLockTaskEscapeMessage();
            }
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048795, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startLockTask();
            } else {
                super.startLockTask();
            }
        }
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startPostponedEnterTransition();
            } else {
                super.startPostponedEnterTransition();
            }
        }
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048801, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.stopLocalVoiceInteraction();
            } else {
                super.stopLocalVoiceInteraction();
            }
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048802, this) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.stopLockTask();
            } else {
                super.stopLockTask();
            }
        }
    }

    public void zeusSuperCloseContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048810, this) == null) {
            super.closeContextMenu();
        }
    }

    public void zeusSuperCloseOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048811, this) == null) {
            super.closeOptionsMenu();
        }
    }

    public void zeusSuperEnterPictureInPictureMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048821, this) == null) {
            super.enterPictureInPictureMode();
        }
    }

    public void zeusSuperFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048824, this) == null) {
            super.finish();
        }
    }

    public void zeusSuperFinishAffinity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048827, this) == null) {
            super.finishAffinity();
        }
    }

    public void zeusSuperFinishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048828, this) == null) {
            super.finishAfterTransition();
        }
    }

    public void zeusSuperFinishAndRemoveTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048829, this) == null) {
            super.finishAndRemoveTask();
        }
    }

    public ActionBar zeusSuperGetActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048831, this)) == null) {
            return super.getActionBar();
        }
        return (ActionBar) invokeV.objValue;
    }

    public ComponentName zeusSuperGetCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048832, this)) == null) {
            return super.getCallingActivity();
        }
        return (ComponentName) invokeV.objValue;
    }

    public String zeusSuperGetCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048833, this)) == null) {
            return super.getCallingPackage();
        }
        return (String) invokeV.objValue;
    }

    public int zeusSuperGetChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048834, this)) == null) {
            return super.getChangingConfigurations();
        }
        return invokeV.intValue;
    }

    public ComponentName zeusSuperGetComponentName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048835, this)) == null) {
            return super.getComponentName();
        }
        return (ComponentName) invokeV.objValue;
    }

    public Scene zeusSuperGetContentScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048836, this)) == null) {
            return super.getContentScene();
        }
        return (Scene) invokeV.objValue;
    }

    public TransitionManager zeusSuperGetContentTransitionManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048837, this)) == null) {
            return super.getContentTransitionManager();
        }
        return (TransitionManager) invokeV.objValue;
    }

    public View zeusSuperGetCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048838, this)) == null) {
            return super.getCurrentFocus();
        }
        return (View) invokeV.objValue;
    }

    public FragmentManager zeusSuperGetFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048839, this)) == null) {
            return super.getFragmentManager();
        }
        return (FragmentManager) invokeV.objValue;
    }

    public Intent zeusSuperGetIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048840, this)) == null) {
            return super.getIntent();
        }
        return (Intent) invokeV.objValue;
    }

    public Object zeusSuperGetLastNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048841, this)) == null) {
            return super.getLastNonConfigurationInstance();
        }
        return invokeV.objValue;
    }

    public LayoutInflater zeusSuperGetLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048842, this)) == null) {
            return super.getLayoutInflater();
        }
        return (LayoutInflater) invokeV.objValue;
    }

    public Lifecycle zeusSuperGetLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048843, this)) == null) {
            return super.getLifecycle();
        }
        return (Lifecycle) invokeV.objValue;
    }

    public LoaderManager zeusSuperGetLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048844, this)) == null) {
            return super.getLoaderManager();
        }
        return (LoaderManager) invokeV.objValue;
    }

    public String zeusSuperGetLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048845, this)) == null) {
            return super.getLocalClassName();
        }
        return (String) invokeV.objValue;
    }

    public int zeusSuperGetMaxNumPictureInPictureActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048846, this)) == null) {
            return super.getMaxNumPictureInPictureActions();
        }
        return invokeV.intValue;
    }

    public MenuInflater zeusSuperGetMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048847, this)) == null) {
            return super.getMenuInflater();
        }
        return (MenuInflater) invokeV.objValue;
    }

    public Intent zeusSuperGetParentActivityIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048848, this)) == null) {
            return super.getParentActivityIntent();
        }
        return (Intent) invokeV.objValue;
    }

    public Uri zeusSuperGetReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048850, this)) == null) {
            return super.getReferrer();
        }
        return (Uri) invokeV.objValue;
    }

    public int zeusSuperGetRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048851, this)) == null) {
            return super.getRequestedOrientation();
        }
        return invokeV.intValue;
    }

    public androidx.appcompat.app.ActionBar zeusSuperGetSupportActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048852, this)) == null) {
            return super.getSupportActionBar();
        }
        return (androidx.appcompat.app.ActionBar) invokeV.objValue;
    }

    public androidx.fragment.app.FragmentManager zeusSuperGetSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048853, this)) == null) {
            return super.getSupportFragmentManager();
        }
        return (androidx.fragment.app.FragmentManager) invokeV.objValue;
    }

    public int zeusSuperGetTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048855, this)) == null) {
            return super.getTaskId();
        }
        return invokeV.intValue;
    }

    public VoiceInteractor zeusSuperGetVoiceInteractor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048856, this)) == null) {
            return super.getVoiceInteractor();
        }
        return (VoiceInteractor) invokeV.objValue;
    }

    public Window zeusSuperGetWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048857, this)) == null) {
            return super.getWindow();
        }
        return (Window) invokeV.objValue;
    }

    public WindowManager zeusSuperGetWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048858, this)) == null) {
            return super.getWindowManager();
        }
        return (WindowManager) invokeV.objValue;
    }

    public boolean zeusSuperHasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048859, this)) == null) {
            return super.hasWindowFocus();
        }
        return invokeV.booleanValue;
    }

    public void zeusSuperInvalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048860, this) == null) {
            super.invalidateOptionsMenu();
        }
    }

    public boolean zeusSuperIsActivityTransitionRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048861, this)) == null) {
            return super.isActivityTransitionRunning();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048862, this)) == null) {
            return super.isChangingConfigurations();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048863, this)) == null) {
            return super.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048864, this)) == null) {
            return super.isFinishing();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsImmersive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048865, this)) == null) {
            return super.isImmersive();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsInMultiWindowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048866, this)) == null) {
            return super.isInMultiWindowMode();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsInPictureInPictureMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048867, this)) == null) {
            return super.isInPictureInPictureMode();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsLocalVoiceInteractionSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048868, this)) == null) {
            return super.isLocalVoiceInteractionSupported();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048869, this)) == null) {
            return super.isTaskRoot();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsVoiceInteraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048870, this)) == null) {
            return super.isVoiceInteraction();
        }
        return invokeV.booleanValue;
    }

    public boolean zeusSuperIsVoiceInteractionRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048871, this)) == null) {
            return super.isVoiceInteractionRoot();
        }
        return invokeV.booleanValue;
    }

    public void zeusSuperOnAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048881, this) == null) {
            super.onAttachedToWindow();
        }
    }

    public void zeusSuperOnBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048882, this) == null) {
            super.onBackPressed();
        }
    }

    public void zeusSuperOnContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048885, this) == null) {
            super.onContentChanged();
        }
    }

    public CharSequence zeusSuperOnCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048891, this)) == null) {
            return super.onCreateDescription();
        }
        return (CharSequence) invokeV.objValue;
    }

    public void zeusSuperOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048901, this) == null) {
            super.onDestroy();
        }
    }

    public void zeusSuperOnDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048902, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public void zeusSuperOnEnterAnimationComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048903, this) == null) {
            super.onEnterAnimationComplete();
        }
    }

    public void zeusSuperOnLocalVoiceInteractionStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048911, this) == null) {
            super.onLocalVoiceInteractionStarted();
        }
    }

    public void zeusSuperOnLocalVoiceInteractionStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048912, this) == null) {
            super.onLocalVoiceInteractionStopped();
        }
    }

    public void zeusSuperOnLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048913, this) == null) {
            super.onLowMemory();
        }
    }

    public boolean zeusSuperOnNavigateUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048917, this)) == null) {
            return super.onNavigateUp();
        }
        return invokeV.booleanValue;
    }

    public void zeusSuperOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048923, this) == null) {
            super.onPause();
        }
    }

    public boolean zeusSuperOnPictureInPictureRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048927, this)) == null) {
            return super.onPictureInPictureRequested();
        }
        return invokeV.booleanValue;
    }

    public void zeusSuperOnPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048930, this) == null) {
            super.onPostResume();
        }
    }

    public Uri zeusSuperOnProvideReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048939, this)) == null) {
            return super.onProvideReferrer();
        }
        return (Uri) invokeV.objValue;
    }

    public void zeusSuperOnRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048941, this) == null) {
            super.onRestart();
        }
    }

    public void zeusSuperOnResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048944, this) == null) {
            super.onResume();
        }
    }

    public boolean zeusSuperOnSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048947, this)) == null) {
            return super.onSearchRequested();
        }
        return invokeV.booleanValue;
    }

    public void zeusSuperOnStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048949, this) == null) {
            super.onStart();
        }
    }

    public void zeusSuperOnStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048950, this) == null) {
            super.onStateNotSaved();
        }
    }

    public void zeusSuperOnStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048951, this) == null) {
            super.onStop();
        }
    }

    public void zeusSuperOnUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048957, this) == null) {
            super.onUserInteraction();
        }
    }

    public void zeusSuperOnUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048958, this) == null) {
            super.onUserLeaveHint();
        }
    }

    public void zeusSuperOnVisibleBehindCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048959, this) == null) {
            super.onVisibleBehindCanceled();
        }
    }

    public void zeusSuperOpenOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048965, this) == null) {
            super.openOptionsMenu();
        }
    }

    public void zeusSuperPostponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048967, this) == null) {
            super.postponeEnterTransition();
        }
    }

    public void zeusSuperRecreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048968, this) == null) {
            super.recreate();
        }
    }

    public boolean zeusSuperReleaseInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048971, this)) == null) {
            return super.releaseInstance();
        }
        return invokeV.booleanValue;
    }

    public void zeusSuperReportFullyDrawn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048972, this) == null) {
            super.reportFullyDrawn();
        }
    }

    public void zeusSuperShowLockTaskEscapeMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049002, this) == null) {
            super.showLockTaskEscapeMessage();
        }
    }

    public void zeusSuperStartLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049024, this) == null) {
            super.startLockTask();
        }
    }

    public void zeusSuperStartPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049028, this) == null) {
            super.startPostponedEnterTransition();
        }
    }

    public void zeusSuperStopLocalVoiceInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049030, this) == null) {
            super.stopLocalVoiceInteraction();
        }
    }

    public void zeusSuperStopLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049031, this) == null) {
            super.stopLockTask();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void addContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, layoutParams) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.addContentView(view2, layoutParams);
            } else {
                super.addContentView(view2, layoutParams);
            }
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, activity, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.finishActivityFromChild(activity, i);
            } else {
                super.finishActivityFromChild(activity, i);
            }
        }
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048643, this, activity, intent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.navigateUpToFromChild(activity, intent);
            }
            return super.navigateUpToFromChild(activity, intent);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048646, this, i, intent) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onActivityReenter(i, intent);
            } else {
                super.onActivityReenter(i, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048652, this, activity, charSequence) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onChildTitleChanged(activity, charSequence);
            } else {
                super.onChildTitleChanged(activity, charSequence);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, bundle, persistableBundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onCreate(bundle, persistableBundle);
            } else {
                super.onCreate(bundle, persistableBundle);
            }
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048662, this, i, bundle)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreateDialog(i, bundle);
            }
            return super.onCreateDialog(i, bundle);
        }
        return (Dialog) invokeIL.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048665, this, i, menu)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreatePanelMenu(i, menu);
            }
            return super.onCreatePanelMenu(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048667, this, bitmap, canvas)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreateThumbnail(bitmap, canvas);
            }
            return super.onCreateThumbnail(bitmap, canvas);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048674, this, cancellationSignal, consumer) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onGetDirectActions(cancellationSignal, consumer);
            } else {
                super.onGetDirectActions(cancellationSignal, consumer);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048675, this, i, keyEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onKeyDown(i, keyEvent);
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048676, this, i, keyEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onKeyLongPress(i, keyEvent);
            }
            return super.onKeyLongPress(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048678, this, i, keyEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onKeyShortcut(i, keyEvent);
            }
            return super.onKeyShortcut(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048679, this, i, keyEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onKeyUp(i, keyEvent);
            }
            return super.onKeyUp(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048683, this, i, menu)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onMenuOpened(i, menu);
            }
            return super.onMenuOpened(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048685, this, z, configuration) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onMultiWindowModeChanged(z, configuration);
            } else {
                super.onMultiWindowModeChanged(z, configuration);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048691, this, i, menu) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPanelClosed(i, menu);
            } else {
                super.onPanelClosed(i, menu);
            }
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048695, this, z, configuration) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPictureInPictureModeChanged(z, configuration);
            } else {
                super.onPictureInPictureModeChanged(z, configuration);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048698, this, bundle, persistableBundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPostCreate(bundle, persistableBundle);
            } else {
                super.onPostCreate(bundle, persistableBundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048700, this, i, dialog) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPrepareDialog(i, dialog);
            } else {
                super.onPrepareDialog(i, dialog);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048712, this, bundle, persistableBundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onRestoreInstanceState(bundle, persistableBundle);
            } else {
                super.onRestoreInstanceState(bundle, persistableBundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048715, this, bundle, persistableBundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onSaveInstanceState(bundle, persistableBundle);
            } else {
                super.onSaveInstanceState(bundle, persistableBundle);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048721, this, charSequence, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onTitleChanged(charSequence, i);
            } else {
                super.onTitleChanged(charSequence, i);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048732, this, callback, i)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onWindowStartingActionMode(callback, i);
            }
            return super.onWindowStartingActionMode(callback, i);
        }
        return (ActionMode) invokeLI.objValue;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048735, this, i, i2) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.overridePendingTransition(i, i2);
            } else {
                super.overridePendingTransition(i, i2);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048748, this, view2, layoutParams) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setContentView(view2, layoutParams);
            } else {
                super.setContentView(view2, layoutParams);
            }
        }
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048755, this, locusId, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setLocusContext(locusId, bundle);
            } else {
                super.setLocusContext(locusId, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048769, this, z, componentName) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setVrModeEnabled(z, componentName);
            } else {
                super.setVrModeEnabled(z, componentName);
            }
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048775, this, callback, i)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.startActionMode(callback, i);
            }
            return super.startActionMode(callback, i);
        }
        return (ActionMode) invokeLI.objValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048777, this, intentArr, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivities(intentArr, bundle);
            } else {
                super.startActivities(intentArr, bundle);
            }
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048779, this, intent, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivity(intent, bundle);
            } else {
                super.startActivity(intent, bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048780, this, intent, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivityForResult(intent, i);
            } else {
                super.startActivityForResult(intent, i);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048786, this, intent, i)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.startActivityIfNeeded(intent, i);
            }
            return super.startActivityIfNeeded(intent, i);
        }
        return invokeLI.booleanValue;
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048798, this, intent, bundle)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.startNextMatchingActivity(intent, bundle);
            }
            return super.startNextMatchingActivity(intent, bundle);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048805, this, str, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.triggerSearch(str, bundle);
            } else {
                super.triggerSearch(str, bundle);
            }
        }
    }

    public void zeusSuperAddContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048808, this, view2, layoutParams) == null) {
            super.addContentView(view2, layoutParams);
        }
    }

    public void zeusSuperFinishActivityFromChild(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048826, this, activity, i) == null) {
            super.finishActivityFromChild(activity, i);
        }
    }

    public boolean zeusSuperNavigateUpToFromChild(Activity activity, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048874, this, activity, intent)) == null) {
            return super.navigateUpToFromChild(activity, intent);
        }
        return invokeLL.booleanValue;
    }

    public void zeusSuperOnActivityReenter(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048877, this, i, intent) == null) {
            super.onActivityReenter(i, intent);
        }
    }

    public void zeusSuperOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048883, this, activity, charSequence) == null) {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    public void zeusSuperOnCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048889, this, bundle, persistableBundle) == null) {
            super.onCreate(bundle, persistableBundle);
        }
    }

    public Dialog zeusSuperOnCreateDialog(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048893, this, i, bundle)) == null) {
            return super.onCreateDialog(i, bundle);
        }
        return (Dialog) invokeIL.objValue;
    }

    public boolean zeusSuperOnCreatePanelMenu(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048896, this, i, menu)) == null) {
            return super.onCreatePanelMenu(i, menu);
        }
        return invokeIL.booleanValue;
    }

    public boolean zeusSuperOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048898, this, bitmap, canvas)) == null) {
            return super.onCreateThumbnail(bitmap, canvas);
        }
        return invokeLL.booleanValue;
    }

    public void zeusSuperOnGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048905, this, cancellationSignal, consumer) == null) {
            super.onGetDirectActions(cancellationSignal, consumer);
        }
    }

    public boolean zeusSuperOnKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048906, this, i, keyEvent)) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public boolean zeusSuperOnKeyLongPress(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048907, this, i, keyEvent)) == null) {
            return super.onKeyLongPress(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public boolean zeusSuperOnKeyShortcut(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048909, this, i, keyEvent)) == null) {
            return super.onKeyShortcut(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public boolean zeusSuperOnKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048910, this, i, keyEvent)) == null) {
            return super.onKeyUp(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public boolean zeusSuperOnMenuOpened(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048914, this, i, menu)) == null) {
            return super.onMenuOpened(i, menu);
        }
        return invokeIL.booleanValue;
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048916, this, z, configuration) == null) {
            super.onMultiWindowModeChanged(z, configuration);
        }
    }

    public void zeusSuperOnPanelClosed(int i, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048922, this, i, menu) == null) {
            super.onPanelClosed(i, menu);
        }
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048926, this, z, configuration) == null) {
            super.onPictureInPictureModeChanged(z, configuration);
        }
    }

    public void zeusSuperOnPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048929, this, bundle, persistableBundle) == null) {
            super.onPostCreate(bundle, persistableBundle);
        }
    }

    public void zeusSuperOnPrepareDialog(int i, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048931, this, i, dialog) == null) {
            super.onPrepareDialog(i, dialog);
        }
    }

    public void zeusSuperOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048943, this, bundle, persistableBundle) == null) {
            super.onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    public void zeusSuperOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048946, this, bundle, persistableBundle) == null) {
            super.onSaveInstanceState(bundle, persistableBundle);
        }
    }

    public void zeusSuperOnTitleChanged(CharSequence charSequence, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048952, this, charSequence, i) == null) {
            super.onTitleChanged(charSequence, i);
        }
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048963, this, callback, i)) == null) {
            return super.onWindowStartingActionMode(callback, i);
        }
        return (ActionMode) invokeLI.objValue;
    }

    public void zeusSuperOverridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048966, this, i, i2) == null) {
            super.overridePendingTransition(i, i2);
        }
    }

    public void zeusSuperSetContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048979, this, view2, layoutParams) == null) {
            super.setContentView(view2, layoutParams);
        }
    }

    public void zeusSuperSetLocusContext(LocusId locusId, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048986, this, locusId, bundle) == null) {
            super.setLocusContext(locusId, bundle);
        }
    }

    public void zeusSuperSetVrModeEnabled(boolean z, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048998, this, z, componentName) == null) {
            super.setVrModeEnabled(z, componentName);
        }
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1049004, this, callback, i)) == null) {
            return super.startActionMode(callback, i);
        }
        return (ActionMode) invokeLI.objValue;
    }

    public void zeusSuperStartActivities(Intent[] intentArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1049006, this, intentArr, bundle) == null) {
            super.startActivities(intentArr, bundle);
        }
    }

    public void zeusSuperStartActivity(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1049008, this, intent, bundle) == null) {
            super.startActivity(intent, bundle);
        }
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1049009, this, intent, i) == null) {
            super.startActivityForResult(intent, i);
        }
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1049015, this, intent, i)) == null) {
            return super.startActivityIfNeeded(intent, i);
        }
        return invokeLI.booleanValue;
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1049027, this, intent, bundle)) == null) {
            return super.startNextMatchingActivity(intent, bundle);
        }
        return invokeLL.booleanValue;
    }

    public void zeusSuperTriggerSearch(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1049034, this, str, bundle) == null) {
            super.triggerSearch(str, bundle);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            c.a(this, context);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.dispatchGenericMotionEvent(motionEvent);
            }
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, keyEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.dispatchKeyShortcutEvent(keyEvent);
            }
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accessibilityEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.dispatchTrackballEvent(motionEvent);
            }
            return super.dispatchTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pictureInPictureParams)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.enterPictureInPictureMode(pictureInPictureParams);
            }
            return super.enterPictureInPictureMode(pictureInPictureParams);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.findViewById(i);
            }
            return super.findViewById(i);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.finishActivity(i);
            } else {
                super.finishActivity(i);
            }
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.finishFromChild(activity);
            } else {
                super.finishFromChild(activity);
            }
        }
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getPreferences(i);
            }
            return super.getPreferences(i);
        }
        return (SharedPreferences) invokeI.objValue;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.getSystemService(str);
            }
            return super.getSystemService(str);
        }
        return invokeL.objValue;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048641, this, z)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.moveTaskToBack(z);
            }
            return super.moveTaskToBack(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, intent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.navigateUpTo(intent);
            }
            return super.navigateUpTo(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, actionMode) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onActionModeFinished(actionMode);
            } else {
                super.onActionModeFinished(actionMode);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, actionMode) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onActionModeStarted(actionMode);
            } else {
                super.onActionModeStarted(actionMode);
            }
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, fragment) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onAttachFragment(fragment);
            } else {
                super.onAttachFragment(fragment);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, configuration) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onConfigurationChanged(configuration);
            } else {
                super.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, menuItem)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onContextItemSelected(menuItem);
            }
            return super.onContextItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, menu) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onContextMenuClosed(menu);
            } else {
                super.onContextMenuClosed(menu);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, bundle) == null) {
            c.a(this, bundle);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048661, this, i)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreateDialog(i);
            }
            return super.onCreateDialog(i);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, taskStackBuilder) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
            } else {
                super.onCreateNavigateUpTaskStack(taskStackBuilder);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, menu)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreateOptionsMenu(menu);
            }
            return super.onCreateOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048666, this, i)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreatePanelView(i);
            }
            return super.onCreatePanelView(i);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, motionEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onGenericMotionEvent(motionEvent);
            }
            return super.onGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onMultiWindowModeChanged(z);
            } else {
                super.onMultiWindowModeChanged(z);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, activity)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onNavigateUpFromChild(activity);
            }
            return super.onNavigateUpFromChild(activity);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, intent) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onNewIntent(intent);
            } else {
                super.onNewIntent(intent);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, menuItem)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onOptionsItemSelected(menuItem);
            }
            return super.onOptionsItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, menu) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onOptionsMenuClosed(menu);
            } else {
                super.onOptionsMenuClosed(menu);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPictureInPictureModeChanged(z);
            } else {
                super.onPictureInPictureModeChanged(z);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPostCreate(bundle);
            } else {
                super.onPostCreate(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, taskStackBuilder) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
            } else {
                super.onPrepareNavigateUpTaskStack(taskStackBuilder);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048703, this, menu)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onPrepareOptionsMenu(menu);
            }
            return super.onPrepareOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, assistContent) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onProvideAssistContent(assistContent);
            } else {
                super.onProvideAssistContent(assistContent);
            }
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onProvideAssistData(bundle);
            } else {
                super.onProvideAssistData(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onRestoreInstanceState(bundle);
            } else {
                super.onRestoreInstanceState(bundle);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onSaveInstanceState(bundle);
            } else {
                super.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048717, this, searchEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onSearchRequested(searchEvent);
            }
            return super.onSearchRequested(searchEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onTopResumedActivityChanged(z);
            } else {
                super.onTopResumedActivityChanged(z);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048723, this, motionEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048724, this, motionEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onTrackballEvent(motionEvent);
            }
            return super.onTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048725, this, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onTrimMemory(i);
            } else {
                super.onTrimMemory(i);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, layoutParams) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onWindowAttributesChanged(layoutParams);
            } else {
                super.onWindowAttributesChanged(layoutParams);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onWindowFocusChanged(z);
            } else {
                super.onWindowFocusChanged(z);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048731, this, callback)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onWindowStartingActionMode(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }
        return (ActionMode) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void openContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, view2) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.openContextMenu(view2);
            } else {
                super.openContextMenu(view2);
            }
        }
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, activityLifecycleCallbacks) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            } else {
                super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, view2) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.registerForContextMenu(view2);
            } else {
                super.registerForContextMenu(view2);
            }
        }
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048742, this, dragEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.requestDragAndDropPermissions(dragEvent);
            }
            return super.requestDragAndDropPermissions(dragEvent);
        }
        return (DragAndDropPermissions) invokeL.objValue;
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048743, this, z)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.requestVisibleBehind(z);
            }
            return super.requestVisibleBehind(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, toolbar) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setActionBar(toolbar);
            } else {
                super.setActionBar(toolbar);
            }
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, transitionManager) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setContentTransitionManager(transitionManager);
            } else {
                super.setContentTransitionManager(transitionManager);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048746, this, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setContentView(i);
            } else {
                super.setContentView(i);
            }
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, sharedElementCallback) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setEnterSharedElementCallback(sharedElementCallback);
            } else {
                super.setEnterSharedElementCallback(sharedElementCallback);
            }
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, sharedElementCallback) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setExitSharedElementCallback(sharedElementCallback);
            } else {
                super.setExitSharedElementCallback(sharedElementCallback);
            }
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setFinishOnTouchOutside(z);
            } else {
                super.setFinishOnTouchOutside(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setImmersive(z);
            } else {
                super.setImmersive(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048753, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setInheritShowWhenLocked(z);
            } else {
                super.setInheritShowWhenLocked(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, intent) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setIntent(intent);
            } else {
                super.setIntent(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, pictureInPictureParams) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setPictureInPictureParams(pictureInPictureParams);
            } else {
                super.setPictureInPictureParams(pictureInPictureParams);
            }
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setPlugin(Plugin plugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, plugin) == null) {
            this.mPlugin = plugin;
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048758, this, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setRequestedOrientation(i);
            } else {
                super.setRequestedOrientation(i);
            }
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048759, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setShowWhenLocked(z);
            } else {
                super.setShowWhenLocked(z);
            }
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setTargetActivity(IPluginActivity iPluginActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, iPluginActivity) == null) {
            this.mTargetActivity = (GeneratePluginAppCompatActivity) iPluginActivity;
        }
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, taskDescription) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setTaskDescription(taskDescription);
            } else {
                super.setTaskDescription(taskDescription);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048762, this, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setTheme(i);
            } else {
                super.setTheme(i);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048763, this, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setTitle(i);
            } else {
                super.setTitle(i);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048765, this, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setTitleColor(i);
            } else {
                super.setTitleColor(i);
            }
        }
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048766, this, z)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.setTranslucent(z);
            }
            return super.setTranslucent(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048767, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setTurnScreenOn(z);
            } else {
                super.setTurnScreenOn(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048768, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setVisible(z);
            } else {
                super.setVisible(z);
            }
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048770, this, str)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.shouldShowRequestPermissionRationale(str);
            }
            return super.shouldShowRequestPermissionRationale(str);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048771, this, intent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.shouldUpRecreateTask(intent);
            }
            return super.shouldUpRecreateTask(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048772, this, bundle)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.showAssist(bundle);
            }
            return super.showAssist(bundle);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048774, this, callback)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.startActionMode(callback);
            }
            return super.startActionMode(callback);
        }
        return (ActionMode) invokeL.objValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, intentArr) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivities(intentArr);
            } else {
                super.startActivities(intentArr);
            }
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, intent) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivity(intent);
            } else {
                super.startActivity(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048794, this, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startLocalVoiceInteraction(bundle);
            } else {
                super.startLocalVoiceInteraction(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048796, this, cursor) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startManagingCursor(cursor);
            } else {
                super.startManagingCursor(cursor);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048797, this, intent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.startNextMatchingActivity(intent);
            }
            return super.startNextMatchingActivity(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, cursor) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.stopManagingCursor(cursor);
            } else {
                super.stopManagingCursor(cursor);
            }
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048804, this, z) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.takeKeyEvents(z);
            } else {
                super.takeKeyEvents(z);
            }
        }
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, activityLifecycleCallbacks) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            } else {
                super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048807, this, view2) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.unregisterForContextMenu(view2);
            } else {
                super.unregisterForContextMenu(view2);
            }
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperAttachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048809, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    public boolean zeusSuperDispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048814, this, motionEvent)) == null) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048815, this, keyEvent)) == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048816, this, keyEvent)) == null) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048817, this, accessibilityEvent)) == null) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048818, this, motionEvent)) == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048819, this, motionEvent)) == null) {
            return super.dispatchTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048822, this, pictureInPictureParams)) == null) {
            return super.enterPictureInPictureMode(pictureInPictureParams);
        }
        return invokeL.booleanValue;
    }

    public View zeusSuperFindViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048823, this, i)) == null) {
            return super.findViewById(i);
        }
        return (View) invokeI.objValue;
    }

    public void zeusSuperFinishActivity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048825, this, i) == null) {
            super.finishActivity(i);
        }
    }

    public void zeusSuperFinishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048830, this, activity) == null) {
            super.finishFromChild(activity);
        }
    }

    public SharedPreferences zeusSuperGetPreferences(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048849, this, i)) == null) {
            return super.getPreferences(i);
        }
        return (SharedPreferences) invokeI.objValue;
    }

    public Object zeusSuperGetSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048854, this, str)) == null) {
            return super.getSystemService(str);
        }
        return invokeL.objValue;
    }

    public boolean zeusSuperMoveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048872, this, z)) == null) {
            return super.moveTaskToBack(z);
        }
        return invokeZ.booleanValue;
    }

    public boolean zeusSuperNavigateUpTo(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048873, this, intent)) == null) {
            return super.navigateUpTo(intent);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperOnActionModeFinished(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048875, this, actionMode) == null) {
            super.onActionModeFinished(actionMode);
        }
    }

    public void zeusSuperOnActionModeStarted(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048876, this, actionMode) == null) {
            super.onActionModeStarted(actionMode);
        }
    }

    public void zeusSuperOnAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048880, this, fragment) == null) {
            super.onAttachFragment(fragment);
        }
    }

    public void zeusSuperOnConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048884, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    public boolean zeusSuperOnContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048886, this, menuItem)) == null) {
            return super.onContextItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperOnContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048887, this, menu) == null) {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperOnCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048888, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public Dialog zeusSuperOnCreateDialog(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048892, this, i)) == null) {
            return super.onCreateDialog(i);
        }
        return (Dialog) invokeI.objValue;
    }

    public void zeusSuperOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048894, this, taskStackBuilder) == null) {
            super.onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    public boolean zeusSuperOnCreateOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048895, this, menu)) == null) {
            return super.onCreateOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    public View zeusSuperOnCreatePanelView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048897, this, i)) == null) {
            return super.onCreatePanelView(i);
        }
        return (View) invokeI.objValue;
    }

    public boolean zeusSuperOnGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048904, this, motionEvent)) == null) {
            return super.onGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048915, this, z) == null) {
            super.onMultiWindowModeChanged(z);
        }
    }

    public boolean zeusSuperOnNavigateUpFromChild(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048918, this, activity)) == null) {
            return super.onNavigateUpFromChild(activity);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperOnNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048919, this, intent) == null) {
            super.onNewIntent(intent);
        }
    }

    public boolean zeusSuperOnOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048920, this, menuItem)) == null) {
            return super.onOptionsItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperOnOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048921, this, menu) == null) {
            super.onOptionsMenuClosed(menu);
        }
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048925, this, z) == null) {
            super.onPictureInPictureModeChanged(z);
        }
    }

    public void zeusSuperOnPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048928, this, bundle) == null) {
            super.onPostCreate(bundle);
        }
    }

    public void zeusSuperOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048933, this, taskStackBuilder) == null) {
            super.onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    public boolean zeusSuperOnPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048934, this, menu)) == null) {
            return super.onPrepareOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperOnProvideAssistContent(AssistContent assistContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048936, this, assistContent) == null) {
            super.onProvideAssistContent(assistContent);
        }
    }

    public void zeusSuperOnProvideAssistData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048937, this, bundle) == null) {
            super.onProvideAssistData(bundle);
        }
    }

    public void zeusSuperOnRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048942, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    public void zeusSuperOnSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048945, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public boolean zeusSuperOnSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048948, this, searchEvent)) == null) {
            return super.onSearchRequested(searchEvent);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperOnTopResumedActivityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048953, this, z) == null) {
            super.onTopResumedActivityChanged(z);
        }
    }

    public boolean zeusSuperOnTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048954, this, motionEvent)) == null) {
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperOnTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048955, this, motionEvent)) == null) {
            return super.onTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperOnTrimMemory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048956, this, i) == null) {
            super.onTrimMemory(i);
        }
    }

    public void zeusSuperOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048960, this, layoutParams) == null) {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    public void zeusSuperOnWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048961, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048962, this, callback)) == null) {
            return super.onWindowStartingActionMode(callback);
        }
        return (ActionMode) invokeL.objValue;
    }

    public void zeusSuperOpenContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048964, this, view2) == null) {
            super.openContextMenu(view2);
        }
    }

    public void zeusSuperRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048969, this, activityLifecycleCallbacks) == null) {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void zeusSuperRegisterForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048970, this, view2) == null) {
            super.registerForContextMenu(view2);
        }
    }

    public DragAndDropPermissions zeusSuperRequestDragAndDropPermissions(DragEvent dragEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048973, this, dragEvent)) == null) {
            return super.requestDragAndDropPermissions(dragEvent);
        }
        return (DragAndDropPermissions) invokeL.objValue;
    }

    public boolean zeusSuperRequestVisibleBehind(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048974, this, z)) == null) {
            return super.requestVisibleBehind(z);
        }
        return invokeZ.booleanValue;
    }

    public void zeusSuperSetActionBar(Toolbar toolbar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048975, this, toolbar) == null) {
            super.setActionBar(toolbar);
        }
    }

    public void zeusSuperSetContentTransitionManager(TransitionManager transitionManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048976, this, transitionManager) == null) {
            super.setContentTransitionManager(transitionManager);
        }
    }

    public void zeusSuperSetContentView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048977, this, i) == null) {
            super.setContentView(i);
        }
    }

    public void zeusSuperSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048980, this, sharedElementCallback) == null) {
            super.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    public void zeusSuperSetExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048981, this, sharedElementCallback) == null) {
            super.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    public void zeusSuperSetFinishOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048982, this, z) == null) {
            super.setFinishOnTouchOutside(z);
        }
    }

    public void zeusSuperSetImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048983, this, z) == null) {
            super.setImmersive(z);
        }
    }

    public void zeusSuperSetInheritShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048984, this, z) == null) {
            super.setInheritShowWhenLocked(z);
        }
    }

    public void zeusSuperSetIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048985, this, intent) == null) {
            super.setIntent(intent);
        }
    }

    public void zeusSuperSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048987, this, pictureInPictureParams) == null) {
            super.setPictureInPictureParams(pictureInPictureParams);
        }
    }

    public void zeusSuperSetRequestedOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048988, this, i) == null) {
            super.setRequestedOrientation(i);
        }
    }

    public void zeusSuperSetShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048989, this, z) == null) {
            super.setShowWhenLocked(z);
        }
    }

    public void zeusSuperSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048990, this, taskDescription) == null) {
            super.setTaskDescription(taskDescription);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperSetTheme(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048991, this, i) == null) {
            super.setTheme(i);
        }
    }

    public void zeusSuperSetTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048992, this, i) == null) {
            super.setTitle(i);
        }
    }

    public void zeusSuperSetTitleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048994, this, i) == null) {
            super.setTitleColor(i);
        }
    }

    public boolean zeusSuperSetTranslucent(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048995, this, z)) == null) {
            return super.setTranslucent(z);
        }
        return invokeZ.booleanValue;
    }

    public void zeusSuperSetTurnScreenOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048996, this, z) == null) {
            super.setTurnScreenOn(z);
        }
    }

    public void zeusSuperSetVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048997, this, z) == null) {
            super.setVisible(z);
        }
    }

    public boolean zeusSuperShouldShowRequestPermissionRationale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048999, this, str)) == null) {
            return super.shouldShowRequestPermissionRationale(str);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperShouldUpRecreateTask(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1049000, this, intent)) == null) {
            return super.shouldUpRecreateTask(intent);
        }
        return invokeL.booleanValue;
    }

    public boolean zeusSuperShowAssist(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1049001, this, bundle)) == null) {
            return super.showAssist(bundle);
        }
        return invokeL.booleanValue;
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1049003, this, callback)) == null) {
            return super.startActionMode(callback);
        }
        return (ActionMode) invokeL.objValue;
    }

    public void zeusSuperStartActivities(Intent[] intentArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049005, this, intentArr) == null) {
            super.startActivities(intentArr);
        }
    }

    public void zeusSuperStartActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049007, this, intent) == null) {
            super.startActivity(intent);
        }
    }

    public void zeusSuperStartLocalVoiceInteraction(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049023, this, bundle) == null) {
            super.startLocalVoiceInteraction(bundle);
        }
    }

    public void zeusSuperStartManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049025, this, cursor) == null) {
            super.startManagingCursor(cursor);
        }
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1049026, this, intent)) == null) {
            return super.startNextMatchingActivity(intent);
        }
        return invokeL.booleanValue;
    }

    public void zeusSuperStopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049032, this, cursor) == null) {
            super.stopManagingCursor(cursor);
        }
    }

    public void zeusSuperTakeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1049033, this, z) == null) {
            super.takeKeyEvents(z);
        }
    }

    public void zeusSuperUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049035, this, activityLifecycleCallbacks) == null) {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void zeusSuperUnregisterForContextMenu(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049036, this, view2) == null) {
            super.unregisterForContextMenu(view2);
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), intent, Integer.valueOf(i2)})) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.createPendingResult(i, intent, i2);
            }
            return super.createPendingResult(i, intent, i2);
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{theme, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onApplyThemeResource(theme, i, z);
            } else {
                super.onApplyThemeResource(theme, i, z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, fileDescriptor, printWriter, strArr) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.dump(str, fileDescriptor, printWriter, strArr);
            } else {
                super.dump(str, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048668, this, view2, str, context, attributeSet)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreateView(view2, str, context, attributeSet);
            }
            return super.onCreateView(view2, str, context, attributeSet);
        }
        return (View) invokeLLLL.objValue;
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048693, this, str, bundle, cancellationSignal, consumer) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
            } else {
                super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048783, this, activity, intent, i, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivityFromChild(activity, intent, i, bundle);
            } else {
                super.startActivityFromChild(activity, intent, i, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048785, this, fragment, intent, i, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivityFromFragment(fragment, intent, i, bundle);
            } else {
                super.startActivityFromFragment(fragment, intent, i, bundle);
            }
        }
    }

    public void zeusSuperDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048820, this, str, fileDescriptor, printWriter, strArr) == null) {
            super.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public View zeusSuperOnCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048899, this, view2, str, context, attributeSet)) == null) {
            return super.onCreateView(view2, str, context, attributeSet);
        }
        return (View) invokeLLLL.objValue;
    }

    public void zeusSuperOnPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048924, this, str, bundle, cancellationSignal, consumer) == null) {
            super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1049012, this, activity, intent, i, bundle) == null) {
            super.startActivityFromChild(activity, intent, i, bundle);
        }
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1049014, this, fragment, intent, i, bundle) == null) {
            super.startActivityFromFragment(fragment, intent, i, bundle);
        }
    }

    public void zeusSuperStartSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049029, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048647, this, i, i2, intent) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onActivityResult(i, i2, intent);
            } else {
                super.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048659, this, contextMenu, view2, contextMenuInfo) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
            } else {
                super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048669, this, str, context, attributeSet)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onCreateView(str, context, attributeSet);
            }
            return super.onCreateView(str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048677, this, i, i2, keyEvent)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onKeyMultiple(i, i2, keyEvent);
            }
            return super.onKeyMultiple(i, i2, keyEvent);
        }
        return invokeIIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048701, this, i, dialog, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onPrepareDialog(i, dialog, bundle);
            } else {
                super.onPrepareDialog(i, dialog, bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view2, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048704, this, i, view2, menu)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.onPreparePanel(i, view2, menu);
            }
            return super.onPreparePanel(i, view2, menu);
        }
        return invokeILL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048707, this, list, menu, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048709, this, i, strArr, iArr) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.onRequestPermissionsResult(i, strArr, iArr);
            } else {
                super.onRequestPermissionsResult(i, strArr, iArr);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048781, this, intent, i, bundle) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivityForResult(intent, i, bundle);
            } else {
                super.startActivityForResult(intent, i, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048782, this, activity, intent, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivityFromChild(activity, intent, i);
            } else {
                super.startActivityFromChild(activity, intent, i);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048784, this, fragment, intent, i) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startActivityFromFragment(fragment, intent, i);
            } else {
                super.startActivityFromFragment(fragment, intent, i);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048787, this, intent, i, bundle)) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                return generatePluginAppCompatActivity.startActivityIfNeeded(intent, i, bundle);
            }
            return super.startActivityIfNeeded(intent, i, bundle);
        }
        return invokeLIL.booleanValue;
    }

    public PendingIntent zeusSuperCreatePendingResult(int i, Intent intent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048813, this, new Object[]{Integer.valueOf(i), intent, Integer.valueOf(i2)})) == null) {
            return super.createPendingResult(i, intent, i2);
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    public void zeusSuperOnActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048878, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void zeusSuperOnApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048879, this, new Object[]{theme, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.onApplyThemeResource(theme, i, z);
        }
    }

    public void zeusSuperOnCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048890, this, contextMenu, view2, contextMenuInfo) == null) {
            super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        }
    }

    public View zeusSuperOnCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048900, this, str, context, attributeSet)) == null) {
            return super.onCreateView(str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }

    public boolean zeusSuperOnKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048908, this, i, i2, keyEvent)) == null) {
            return super.onKeyMultiple(i, i2, keyEvent);
        }
        return invokeIIL.booleanValue;
    }

    public void zeusSuperOnPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048932, this, i, dialog, bundle) == null) {
            super.onPrepareDialog(i, dialog, bundle);
        }
    }

    public boolean zeusSuperOnPreparePanel(int i, View view2, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048935, this, i, view2, menu)) == null) {
            return super.onPreparePanel(i, view2, menu);
        }
        return invokeILL.booleanValue;
    }

    public void zeusSuperOnProvideKeyboardShortcuts(List list, Menu menu, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048938, this, list, menu, i) == null) {
            super.onProvideKeyboardShortcuts(list, menu, i);
        }
    }

    public void zeusSuperOnRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048940, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1049010, this, intent, i, bundle) == null) {
            super.startActivityForResult(intent, i, bundle);
        }
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1049011, this, activity, intent, i) == null) {
            super.startActivityFromChild(activity, intent, i);
        }
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1049013, this, fragment, intent, i) == null) {
            super.startActivityFromFragment(fragment, intent, i);
        }
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1049016, this, intent, i, bundle)) == null) {
            return super.startActivityIfNeeded(intent, i, bundle);
        }
        return invokeLIL.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, view2) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setContentView(view2);
            } else {
                super.setContentView(view2);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, charSequence) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.setTitle(charSequence);
            } else {
                super.setTitle(charSequence);
            }
        }
    }

    public void zeusSuperSetContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048978, this, view2) == null) {
            super.setContentView(view2);
        }
    }

    public void zeusSuperSetTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048993, this, charSequence) == null) {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048788, this, new Object[]{intentSender, intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startIntentSender(intentSender, intent, i, i2, i3);
            } else {
                super.startIntentSender(intentSender, intent, i, i2, i3);
            }
        }
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049017, this, new Object[]{intentSender, intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            super.startIntentSender(intentSender, intent, i, i2, i3);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048789, this, new Object[]{intentSender, intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bundle}) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startIntentSender(intentSender, intent, i, i2, i3, bundle);
            } else {
                super.startIntentSender(intentSender, intent, i, i2, i3, bundle);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048790, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
            } else {
                super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048791, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
            } else {
                super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048792, this, new Object[]{activity, intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
            } else {
                super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
            }
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048793, this, new Object[]{activity, intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
            } else {
                super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
            }
        }
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049022, this, new Object[]{activity, intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048800, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            GeneratePluginAppCompatActivity generatePluginAppCompatActivity = this.mTargetActivity;
            if (generatePluginAppCompatActivity != null) {
                generatePluginAppCompatActivity.startSearch(str, z, bundle, z2);
            } else {
                super.startSearch(str, z, bundle, z2);
            }
        }
    }

    public boolean zeusSuperConvertToTranslucent(Activity.TranslucentConversionListener translucentConversionListener, ActivityOptions activityOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048812, this, translucentConversionListener, activityOptions)) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", Class.forName("android.app.Activity$TranslucentConversionListener"), ActivityOptions.class);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(this, translucentConversionListener, activityOptions)).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049018, this, new Object[]{intentSender, intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bundle}) == null) {
            super.startIntentSender(intentSender, intent, i, i2, i3, bundle);
        }
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049019, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049020, this, new Object[]{intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049021, this, new Object[]{activity, intentSender, Integer.valueOf(i), intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
        }
    }
}
