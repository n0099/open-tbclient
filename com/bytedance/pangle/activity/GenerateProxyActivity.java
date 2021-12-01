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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
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
@Keep
/* loaded from: classes12.dex */
public abstract class GenerateProxyActivity extends Activity implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Plugin mPlugin;
    public GeneratePluginActivity mTargetActivity;

    public GenerateProxyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, layoutParams) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.addContentView(view, layoutParams);
            } else {
                super.addContentView(view, layoutParams);
            }
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            c.a(this, context);
        }
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.closeContextMenu();
            } else {
                super.closeContextMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.closeOptionsMenu();
            } else {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), intent, Integer.valueOf(i3)})) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.createPendingResult(i2, intent, i3);
            }
            return super.createPendingResult(i2, intent, i3);
        }
        return (PendingIntent) invokeCommon.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.dispatchGenericMotionEvent(motionEvent);
            }
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, keyEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.dispatchKeyShortcutEvent(keyEvent);
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.dispatchTouchEvent(motionEvent);
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.dispatchTrackballEvent(motionEvent);
            }
            return super.dispatchTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, fileDescriptor, printWriter, strArr) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.dump(str, fileDescriptor, printWriter, strArr);
            } else {
                super.dump(str, fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.enterPictureInPictureMode();
            } else {
                super.enterPictureInPictureMode();
            }
        }
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.findViewById(i2);
            }
            return super.findViewById(i2);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.b
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.finish();
            } else {
                super.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.finishActivity(i2);
            } else {
                super.finishActivity(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, activity, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.finishActivityFromChild(activity, i2);
            } else {
                super.finishActivityFromChild(activity, i2);
            }
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.finishAffinity();
            } else {
                super.finishAffinity();
            }
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.finishAfterTransition();
            } else {
                super.finishAfterTransition();
            }
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.finishAndRemoveTask();
            } else {
                super.finishAndRemoveTask();
            }
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.finishFromChild(activity);
            } else {
                super.finishFromChild(activity);
            }
        }
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getActionBar();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getCallingActivity();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getCallingPackage();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getChangingConfigurations();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getComponentName();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getContentScene();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getContentTransitionManager();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getCurrentFocus();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getFragmentManager();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getIntent();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getLastNonConfigurationInstance();
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
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getLayoutInflater();
            }
            return super.getLayoutInflater();
        }
        return (LayoutInflater) invokeV.objValue;
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getLoaderManager();
            }
            return super.getLoaderManager();
        }
        return (LoaderManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getLocalClassName();
            }
            return super.getLocalClassName();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getMaxNumPictureInPictureActions();
            }
            return super.getMaxNumPictureInPictureActions();
        }
        return invokeV.intValue;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getMenuInflater();
            }
            return super.getMenuInflater();
        }
        return (MenuInflater) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getParentActivityIntent();
            }
            return super.getParentActivityIntent();
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.bytedance.pangle.activity.b
    public Plugin getPlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mPlugin : (Plugin) invokeV.objValue;
    }

    @Override // com.bytedance.pangle.activity.b
    public abstract String getPluginPkgName();

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getPreferences(i2);
            }
            return super.getPreferences(i2);
        }
        return (SharedPreferences) invokeI.objValue;
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getReferrer();
            }
            return super.getReferrer();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getRequestedOrientation();
            }
            return super.getRequestedOrientation();
        }
        return invokeV.intValue;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getSystemService(str);
            }
            return super.getSystemService(str);
        }
        return invokeL.objValue;
    }

    @Override // android.app.Activity
    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getTaskId();
            }
            return super.getTaskId();
        }
        return invokeV.intValue;
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getVoiceInteractor();
            }
            return super.getVoiceInteractor();
        }
        return (VoiceInteractor) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getWindow();
            }
            return super.getWindow();
        }
        return (Window) invokeV.objValue;
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.getWindowManager();
            }
            return super.getWindowManager();
        }
        return (WindowManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.hasWindowFocus();
            }
            return super.hasWindowFocus();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.invalidateOptionsMenu();
            } else {
                super.invalidateOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isActivityTransitionRunning();
            }
            return super.isActivityTransitionRunning();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isChangingConfigurations();
            }
            return super.isChangingConfigurations();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isDestroyed();
            }
            return super.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isFinishing();
            }
            return super.isFinishing();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isImmersive();
            }
            return super.isImmersive();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isInMultiWindowMode();
            }
            return super.isInMultiWindowMode();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isInPictureInPictureMode();
            }
            return super.isInPictureInPictureMode();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isLocalVoiceInteractionSupported();
            }
            return super.isLocalVoiceInteractionSupported();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isTaskRoot();
            }
            return super.isTaskRoot();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isVoiceInteraction();
            }
            return super.isVoiceInteraction();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.isVoiceInteractionRoot();
            }
            return super.isVoiceInteractionRoot();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.moveTaskToBack(z);
            }
            return super.moveTaskToBack(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, intent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.navigateUpTo(intent);
            }
            return super.navigateUpTo(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048640, this, activity, intent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.navigateUpToFromChild(activity, intent);
            }
            return super.navigateUpToFromChild(activity, intent);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, actionMode) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onActionModeFinished(actionMode);
            } else {
                super.onActionModeFinished(actionMode);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, actionMode) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onActionModeStarted(actionMode);
            } else {
                super.onActionModeStarted(actionMode);
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i2, intent) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onActivityReenter(i2, intent);
            } else {
                super.onActivityReenter(i2, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048644, this, i2, i3, intent) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onActivityResult(i2, i3, intent);
            } else {
                super.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onApplyThemeResource(theme, i2, z);
            } else {
                super.onApplyThemeResource(theme, i2, z);
            }
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, fragment) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onAttachFragment(fragment);
            } else {
                super.onAttachFragment(fragment);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onAttachedToWindow();
            } else {
                super.onAttachedToWindow();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onBackPressed();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, activity, charSequence) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onChildTitleChanged(activity, charSequence);
            } else {
                super.onChildTitleChanged(activity, charSequence);
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, configuration) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onConfigurationChanged(configuration);
            } else {
                super.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onContentChanged();
            } else {
                super.onContentChanged();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, menuItem)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onContextItemSelected(menuItem);
            }
            return super.onContextItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, menu) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onContextMenuClosed(menu);
            } else {
                super.onContextMenuClosed(menu);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, bundle) == null) {
            c.a(this, bundle);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048656, this, contextMenu, view, contextMenuInfo) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            } else {
                super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            }
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreateDescription();
            }
            return super.onCreateDescription();
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i2)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreateDialog(i2);
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, taskStackBuilder) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
            } else {
                super.onCreateNavigateUpTaskStack(taskStackBuilder);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, menu)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreateOptionsMenu(menu);
            }
            return super.onCreateOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048662, this, i2, menu)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreatePanelMenu(i2, menu);
            }
            return super.onCreatePanelMenu(i2, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048663, this, i2)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreatePanelView(i2);
            }
            return super.onCreatePanelView(i2);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048664, this, bitmap, canvas)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreateThumbnail(bitmap, canvas);
            }
            return super.onCreateThumbnail(bitmap, canvas);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048665, this, view, str, context, attributeSet)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreateView(view, str, context, attributeSet);
            }
            return super.onCreateView(view, str, context, attributeSet);
        }
        return (View) invokeLLLL.objValue;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onDestroy();
            } else {
                super.onDestroy();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onDetachedFromWindow();
            } else {
                super.onDetachedFromWindow();
            }
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onEnterAnimationComplete();
            } else {
                super.onEnterAnimationComplete();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, motionEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onGenericMotionEvent(motionEvent);
            }
            return super.onGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048671, this, cancellationSignal, consumer) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onGetDirectActions(cancellationSignal, consumer);
            } else {
                super.onGetDirectActions(cancellationSignal, consumer);
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048672, this, i2, keyEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048673, this, i2, keyEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onKeyLongPress(i2, keyEvent);
            }
            return super.onKeyLongPress(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048674, this, i2, i3, keyEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onKeyMultiple(i2, i3, keyEvent);
            }
            return super.onKeyMultiple(i2, i3, keyEvent);
        }
        return invokeIIL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048675, this, i2, keyEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onKeyShortcut(i2, keyEvent);
            }
            return super.onKeyShortcut(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048676, this, i2, keyEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onKeyUp(i2, keyEvent);
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onLocalVoiceInteractionStarted();
            } else {
                super.onLocalVoiceInteractionStarted();
            }
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onLocalVoiceInteractionStopped();
            } else {
                super.onLocalVoiceInteractionStopped();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onLowMemory();
            } else {
                super.onLowMemory();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048680, this, i2, menu)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onMenuOpened(i2, menu);
            }
            return super.onMenuOpened(i2, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onMultiWindowModeChanged(z);
            } else {
                super.onMultiWindowModeChanged(z);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onNavigateUp();
            }
            return super.onNavigateUp();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048684, this, activity)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onNavigateUpFromChild(activity);
            }
            return super.onNavigateUpFromChild(activity);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, intent) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onNewIntent(intent);
            } else {
                super.onNewIntent(intent);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, menuItem)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onOptionsItemSelected(menuItem);
            }
            return super.onOptionsItemSelected(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, menu) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onOptionsMenuClosed(menu);
            } else {
                super.onOptionsMenuClosed(menu);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048688, this, i2, menu) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPanelClosed(i2, menu);
            } else {
                super.onPanelClosed(i2, menu);
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPause();
            } else {
                super.onPause();
            }
        }
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048690, this, str, bundle, cancellationSignal, consumer) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
            } else {
                super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
            }
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPictureInPictureModeChanged(z);
            } else {
                super.onPictureInPictureModeChanged(z);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onPictureInPictureRequested();
            }
            return super.onPictureInPictureRequested();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPostCreate(bundle);
            } else {
                super.onPostCreate(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPostResume();
            } else {
                super.onPostResume();
            }
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048697, this, i2, dialog) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPrepareDialog(i2, dialog);
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, taskStackBuilder) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
            } else {
                super.onPrepareNavigateUpTaskStack(taskStackBuilder);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, menu)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onPrepareOptionsMenu(menu);
            }
            return super.onPrepareOptionsMenu(menu);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048701, this, i2, view, menu)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onPreparePanel(i2, view, menu);
            }
            return super.onPreparePanel(i2, view, menu);
        }
        return invokeILL.booleanValue;
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, assistContent) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onProvideAssistContent(assistContent);
            } else {
                super.onProvideAssistContent(assistContent);
            }
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onProvideAssistData(bundle);
            } else {
                super.onProvideAssistData(bundle);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048704, this, list, menu, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            }
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onProvideReferrer();
            }
            return super.onProvideReferrer();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048706, this, i2, strArr, iArr) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onRequestPermissionsResult(i2, strArr, iArr);
            } else {
                super.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onRestart();
            } else {
                super.onRestart();
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onRestoreInstanceState(bundle);
            } else {
                super.onRestoreInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onResume();
            } else {
                super.onResume();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onSaveInstanceState(bundle);
            } else {
                super.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onSearchRequested();
            }
            return super.onSearchRequested();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onStart();
            } else {
                super.onStart();
            }
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onStateNotSaved();
            } else {
                super.onStateNotSaved();
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onStop();
            } else {
                super.onStop();
            }
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048718, this, charSequence, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onTitleChanged(charSequence, i2);
            } else {
                super.onTitleChanged(charSequence, i2);
            }
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onTopResumedActivityChanged(z);
            } else {
                super.onTopResumedActivityChanged(z);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048720, this, motionEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048721, this, motionEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onTrackballEvent(motionEvent);
            }
            return super.onTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onTrimMemory(i2);
            } else {
                super.onTrimMemory(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onUserInteraction();
            } else {
                super.onUserInteraction();
            }
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onUserLeaveHint();
            } else {
                super.onUserLeaveHint();
            }
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onVisibleBehindCanceled();
            } else {
                super.onVisibleBehindCanceled();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, layoutParams) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onWindowAttributesChanged(layoutParams);
            } else {
                super.onWindowAttributesChanged(layoutParams);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onWindowFocusChanged(z);
            } else {
                super.onWindowFocusChanged(z);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048728, this, callback)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onWindowStartingActionMode(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }
        return (ActionMode) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, view) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.openContextMenu(view);
            } else {
                super.openContextMenu(view);
            }
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.openOptionsMenu();
            } else {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048732, this, i2, i3) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.overridePendingTransition(i2, i3);
            } else {
                super.overridePendingTransition(i2, i3);
            }
        }
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.postponeEnterTransition();
            } else {
                super.postponeEnterTransition();
            }
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.recreate();
            } else {
                super.recreate();
            }
        }
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, activityLifecycleCallbacks) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            } else {
                super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, view) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.registerForContextMenu(view);
            } else {
                super.registerForContextMenu(view);
            }
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.releaseInstance();
            }
            return super.releaseInstance();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.reportFullyDrawn();
            } else {
                super.reportFullyDrawn();
            }
        }
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048739, this, dragEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.requestDragAndDropPermissions(dragEvent);
            }
            return super.requestDragAndDropPermissions(dragEvent);
        }
        return (DragAndDropPermissions) invokeL.objValue;
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048740, this, z)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.requestVisibleBehind(z);
            }
            return super.requestVisibleBehind(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, toolbar) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setActionBar(toolbar);
            } else {
                super.setActionBar(toolbar);
            }
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, transitionManager) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setContentTransitionManager(transitionManager);
            } else {
                super.setContentTransitionManager(transitionManager);
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setContentView(i2);
            } else {
                super.setContentView(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, sharedElementCallback) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setEnterSharedElementCallback(sharedElementCallback);
            } else {
                super.setEnterSharedElementCallback(sharedElementCallback);
            }
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, sharedElementCallback) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setExitSharedElementCallback(sharedElementCallback);
            } else {
                super.setExitSharedElementCallback(sharedElementCallback);
            }
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setFinishOnTouchOutside(z);
            } else {
                super.setFinishOnTouchOutside(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setImmersive(z);
            } else {
                super.setImmersive(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setInheritShowWhenLocked(z);
            } else {
                super.setInheritShowWhenLocked(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, intent) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setIntent(intent);
            } else {
                super.setIntent(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048752, this, locusId, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setLocusContext(locusId, bundle);
            } else {
                super.setLocusContext(locusId, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, pictureInPictureParams) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setPictureInPictureParams(pictureInPictureParams);
            } else {
                super.setPictureInPictureParams(pictureInPictureParams);
            }
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setPlugin(Plugin plugin2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, plugin2) == null) {
            this.mPlugin = plugin2;
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048755, this, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setRequestedOrientation(i2);
            } else {
                super.setRequestedOrientation(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setShowWhenLocked(z);
            } else {
                super.setShowWhenLocked(z);
            }
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void setTargetActivity(IPluginActivity iPluginActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, iPluginActivity) == null) {
            this.mTargetActivity = (GeneratePluginActivity) iPluginActivity;
        }
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, taskDescription) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setTaskDescription(taskDescription);
            } else {
                super.setTaskDescription(taskDescription);
            }
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048759, this, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setTheme(i2);
            } else {
                super.setTheme(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048760, this, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setTitle(i2);
            } else {
                super.setTitle(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048762, this, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setTitleColor(i2);
            } else {
                super.setTitleColor(i2);
            }
        }
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048763, this, z)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.setTranslucent(z);
            }
            return super.setTranslucent(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048764, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setTurnScreenOn(z);
            } else {
                super.setTurnScreenOn(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048765, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setVisible(z);
            } else {
                super.setVisible(z);
            }
        }
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048766, this, z, componentName) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setVrModeEnabled(z, componentName);
            } else {
                super.setVrModeEnabled(z, componentName);
            }
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048767, this, str)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.shouldShowRequestPermissionRationale(str);
            }
            return super.shouldShowRequestPermissionRationale(str);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048768, this, intent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.shouldUpRecreateTask(intent);
            }
            return super.shouldUpRecreateTask(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048769, this, bundle)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.showAssist(bundle);
            }
            return super.showAssist(bundle);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.showLockTaskEscapeMessage();
            } else {
                super.showLockTaskEscapeMessage();
            }
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048771, this, callback)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.startActionMode(callback);
            }
            return super.startActionMode(callback);
        }
        return (ActionMode) invokeL.objValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, intentArr) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivities(intentArr);
            } else {
                super.startActivities(intentArr);
            }
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, intent) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivity(intent);
            } else {
                super.startActivity(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048777, this, intent, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivityForResult(intent, i2);
            } else {
                super.startActivityForResult(intent, i2);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048779, this, activity, intent, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivityFromChild(activity, intent, i2);
            } else {
                super.startActivityFromChild(activity, intent, i2);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048781, this, fragment, intent, i2) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivityFromFragment(fragment, intent, i2);
            } else {
                super.startActivityFromFragment(fragment, intent, i2);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048783, this, intent, i2)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.startActivityIfNeeded(intent, i2);
            }
            return super.startActivityIfNeeded(intent, i2);
        }
        return invokeLI.booleanValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048785, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startIntentSender(intentSender, intent, i2, i3, i4);
            } else {
                super.startIntentSender(intentSender, intent, i2, i3, i4);
            }
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048787, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
            } else {
                super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
            }
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048789, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
            } else {
                super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
            }
        }
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startLocalVoiceInteraction(bundle);
            } else {
                super.startLocalVoiceInteraction(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048792, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startLockTask();
            } else {
                super.startLockTask();
            }
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, cursor) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startManagingCursor(cursor);
            } else {
                super.startManagingCursor(cursor);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048794, this, intent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.startNextMatchingActivity(intent);
            }
            return super.startNextMatchingActivity(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048796, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startPostponedEnterTransition();
            } else {
                super.startPostponedEnterTransition();
            }
        }
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048797, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startSearch(str, z, bundle, z2);
            } else {
                super.startSearch(str, z, bundle, z2);
            }
        }
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.stopLocalVoiceInteraction();
            } else {
                super.stopLocalVoiceInteraction();
            }
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.stopLockTask();
            } else {
                super.stopLockTask();
            }
        }
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, cursor) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.stopManagingCursor(cursor);
            } else {
                super.stopManagingCursor(cursor);
            }
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.takeKeyEvents(z);
            } else {
                super.takeKeyEvents(z);
            }
        }
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048802, this, str, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.triggerSearch(str, bundle);
            } else {
                super.triggerSearch(str, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, activityLifecycleCallbacks) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            } else {
                super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048804, this, view) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.unregisterForContextMenu(view);
            } else {
                super.unregisterForContextMenu(view);
            }
        }
    }

    public void zeusSuperAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048805, this, view, layoutParams) == null) {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperAttachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    public void zeusSuperCloseContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048807, this) == null) {
            super.closeContextMenu();
        }
    }

    public void zeusSuperCloseOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048808, this) == null) {
            super.closeOptionsMenu();
        }
    }

    public boolean zeusSuperConvertToTranslucent(Activity.TranslucentConversionListener translucentConversionListener, ActivityOptions activityOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048809, this, translucentConversionListener, activityOptions)) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", Class.forName("android.app.Activity$TranslucentConversionListener"), ActivityOptions.class);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(this, translucentConversionListener, activityOptions)).booleanValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public PendingIntent zeusSuperCreatePendingResult(int i2, Intent intent, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048810, this, new Object[]{Integer.valueOf(i2), intent, Integer.valueOf(i3)})) == null) ? super.createPendingResult(i2, intent, i3) : (PendingIntent) invokeCommon.objValue;
    }

    public boolean zeusSuperDispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048811, this, motionEvent)) == null) ? super.dispatchGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048812, this, keyEvent)) == null) ? super.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048813, this, keyEvent)) == null) ? super.dispatchKeyShortcutEvent(keyEvent) : invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048814, this, accessibilityEvent)) == null) ? super.dispatchPopulateAccessibilityEvent(accessibilityEvent) : invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048815, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public boolean zeusSuperDispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048816, this, motionEvent)) == null) ? super.dispatchTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    public void zeusSuperDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048817, this, str, fileDescriptor, printWriter, strArr) == null) {
            super.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void zeusSuperEnterPictureInPictureMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048818, this) == null) {
            super.enterPictureInPictureMode();
        }
    }

    public View zeusSuperFindViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048820, this, i2)) == null) ? super.findViewById(i2) : (View) invokeI.objValue;
    }

    public void zeusSuperFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048821, this) == null) {
            super.finish();
        }
    }

    public void zeusSuperFinishActivity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048822, this, i2) == null) {
            super.finishActivity(i2);
        }
    }

    public void zeusSuperFinishActivityFromChild(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048823, this, activity, i2) == null) {
            super.finishActivityFromChild(activity, i2);
        }
    }

    public void zeusSuperFinishAffinity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048824, this) == null) {
            super.finishAffinity();
        }
    }

    public void zeusSuperFinishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048825, this) == null) {
            super.finishAfterTransition();
        }
    }

    public void zeusSuperFinishAndRemoveTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048826, this) == null) {
            super.finishAndRemoveTask();
        }
    }

    public void zeusSuperFinishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048827, this, activity) == null) {
            super.finishFromChild(activity);
        }
    }

    public ActionBar zeusSuperGetActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048828, this)) == null) ? super.getActionBar() : (ActionBar) invokeV.objValue;
    }

    public ComponentName zeusSuperGetCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048829, this)) == null) ? super.getCallingActivity() : (ComponentName) invokeV.objValue;
    }

    public String zeusSuperGetCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048830, this)) == null) ? super.getCallingPackage() : (String) invokeV.objValue;
    }

    public int zeusSuperGetChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048831, this)) == null) ? super.getChangingConfigurations() : invokeV.intValue;
    }

    public ComponentName zeusSuperGetComponentName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048832, this)) == null) ? super.getComponentName() : (ComponentName) invokeV.objValue;
    }

    public Scene zeusSuperGetContentScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048833, this)) == null) ? super.getContentScene() : (Scene) invokeV.objValue;
    }

    public TransitionManager zeusSuperGetContentTransitionManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048834, this)) == null) ? super.getContentTransitionManager() : (TransitionManager) invokeV.objValue;
    }

    public View zeusSuperGetCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048835, this)) == null) ? super.getCurrentFocus() : (View) invokeV.objValue;
    }

    public FragmentManager zeusSuperGetFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048836, this)) == null) ? super.getFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    public Intent zeusSuperGetIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048837, this)) == null) ? super.getIntent() : (Intent) invokeV.objValue;
    }

    public Object zeusSuperGetLastNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048838, this)) == null) ? super.getLastNonConfigurationInstance() : invokeV.objValue;
    }

    public LayoutInflater zeusSuperGetLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048839, this)) == null) ? super.getLayoutInflater() : (LayoutInflater) invokeV.objValue;
    }

    public LoaderManager zeusSuperGetLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048840, this)) == null) ? super.getLoaderManager() : (LoaderManager) invokeV.objValue;
    }

    public String zeusSuperGetLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048841, this)) == null) ? super.getLocalClassName() : (String) invokeV.objValue;
    }

    public int zeusSuperGetMaxNumPictureInPictureActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048842, this)) == null) ? super.getMaxNumPictureInPictureActions() : invokeV.intValue;
    }

    public MenuInflater zeusSuperGetMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048843, this)) == null) ? super.getMenuInflater() : (MenuInflater) invokeV.objValue;
    }

    public Intent zeusSuperGetParentActivityIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048844, this)) == null) ? super.getParentActivityIntent() : (Intent) invokeV.objValue;
    }

    public SharedPreferences zeusSuperGetPreferences(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048845, this, i2)) == null) ? super.getPreferences(i2) : (SharedPreferences) invokeI.objValue;
    }

    public Uri zeusSuperGetReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048846, this)) == null) ? super.getReferrer() : (Uri) invokeV.objValue;
    }

    public int zeusSuperGetRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048847, this)) == null) ? super.getRequestedOrientation() : invokeV.intValue;
    }

    public Object zeusSuperGetSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048848, this, str)) == null) ? super.getSystemService(str) : invokeL.objValue;
    }

    public int zeusSuperGetTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048849, this)) == null) ? super.getTaskId() : invokeV.intValue;
    }

    public VoiceInteractor zeusSuperGetVoiceInteractor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048850, this)) == null) ? super.getVoiceInteractor() : (VoiceInteractor) invokeV.objValue;
    }

    public Window zeusSuperGetWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048851, this)) == null) ? super.getWindow() : (Window) invokeV.objValue;
    }

    public WindowManager zeusSuperGetWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048852, this)) == null) ? super.getWindowManager() : (WindowManager) invokeV.objValue;
    }

    public boolean zeusSuperHasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048853, this)) == null) ? super.hasWindowFocus() : invokeV.booleanValue;
    }

    public void zeusSuperInvalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048854, this) == null) {
            super.invalidateOptionsMenu();
        }
    }

    public boolean zeusSuperIsActivityTransitionRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048855, this)) == null) ? super.isActivityTransitionRunning() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048856, this)) == null) ? super.isChangingConfigurations() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048857, this)) == null) ? super.isDestroyed() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048858, this)) == null) ? super.isFinishing() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsImmersive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048859, this)) == null) ? super.isImmersive() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsInMultiWindowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048860, this)) == null) ? super.isInMultiWindowMode() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsInPictureInPictureMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048861, this)) == null) ? super.isInPictureInPictureMode() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsLocalVoiceInteractionSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048862, this)) == null) ? super.isLocalVoiceInteractionSupported() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048863, this)) == null) ? super.isTaskRoot() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsVoiceInteraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048864, this)) == null) ? super.isVoiceInteraction() : invokeV.booleanValue;
    }

    public boolean zeusSuperIsVoiceInteractionRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048865, this)) == null) ? super.isVoiceInteractionRoot() : invokeV.booleanValue;
    }

    public boolean zeusSuperMoveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048866, this, z)) == null) ? super.moveTaskToBack(z) : invokeZ.booleanValue;
    }

    public boolean zeusSuperNavigateUpTo(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048867, this, intent)) == null) ? super.navigateUpTo(intent) : invokeL.booleanValue;
    }

    public boolean zeusSuperNavigateUpToFromChild(Activity activity, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048868, this, activity, intent)) == null) ? super.navigateUpToFromChild(activity, intent) : invokeLL.booleanValue;
    }

    public void zeusSuperOnActionModeFinished(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048869, this, actionMode) == null) {
            super.onActionModeFinished(actionMode);
        }
    }

    public void zeusSuperOnActionModeStarted(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048870, this, actionMode) == null) {
            super.onActionModeStarted(actionMode);
        }
    }

    public void zeusSuperOnActivityReenter(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048871, this, i2, intent) == null) {
            super.onActivityReenter(i2, intent);
        }
    }

    public void zeusSuperOnActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048872, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void zeusSuperOnApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048873, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.onApplyThemeResource(theme, i2, z);
        }
    }

    public void zeusSuperOnAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048874, this, fragment) == null) {
            super.onAttachFragment(fragment);
        }
    }

    public void zeusSuperOnAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048875, this) == null) {
            super.onAttachedToWindow();
        }
    }

    public void zeusSuperOnBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048876, this) == null) {
            super.onBackPressed();
        }
    }

    public void zeusSuperOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048877, this, activity, charSequence) == null) {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    public void zeusSuperOnConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048878, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    public void zeusSuperOnContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048879, this) == null) {
            super.onContentChanged();
        }
    }

    public boolean zeusSuperOnContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048880, this, menuItem)) == null) ? super.onContextItemSelected(menuItem) : invokeL.booleanValue;
    }

    public void zeusSuperOnContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048881, this, menu) == null) {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperOnCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048882, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public void zeusSuperOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048884, this, contextMenu, view, contextMenuInfo) == null) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    public CharSequence zeusSuperOnCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048885, this)) == null) ? super.onCreateDescription() : (CharSequence) invokeV.objValue;
    }

    public Dialog zeusSuperOnCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048886, this, i2)) == null) ? super.onCreateDialog(i2) : (Dialog) invokeI.objValue;
    }

    public void zeusSuperOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048888, this, taskStackBuilder) == null) {
            super.onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    public boolean zeusSuperOnCreateOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048889, this, menu)) == null) ? super.onCreateOptionsMenu(menu) : invokeL.booleanValue;
    }

    public boolean zeusSuperOnCreatePanelMenu(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048890, this, i2, menu)) == null) ? super.onCreatePanelMenu(i2, menu) : invokeIL.booleanValue;
    }

    public View zeusSuperOnCreatePanelView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048891, this, i2)) == null) ? super.onCreatePanelView(i2) : (View) invokeI.objValue;
    }

    public boolean zeusSuperOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048892, this, bitmap, canvas)) == null) ? super.onCreateThumbnail(bitmap, canvas) : invokeLL.booleanValue;
    }

    public View zeusSuperOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048893, this, view, str, context, attributeSet)) == null) ? super.onCreateView(view, str, context, attributeSet) : (View) invokeLLLL.objValue;
    }

    public void zeusSuperOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048895, this) == null) {
            super.onDestroy();
        }
    }

    public void zeusSuperOnDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048896, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public void zeusSuperOnEnterAnimationComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048897, this) == null) {
            super.onEnterAnimationComplete();
        }
    }

    public boolean zeusSuperOnGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048898, this, motionEvent)) == null) ? super.onGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    public void zeusSuperOnGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048899, this, cancellationSignal, consumer) == null) {
            super.onGetDirectActions(cancellationSignal, consumer);
        }
    }

    public boolean zeusSuperOnKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048900, this, i2, keyEvent)) == null) ? super.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    public boolean zeusSuperOnKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048901, this, i2, keyEvent)) == null) ? super.onKeyLongPress(i2, keyEvent) : invokeIL.booleanValue;
    }

    public boolean zeusSuperOnKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048902, this, i2, i3, keyEvent)) == null) ? super.onKeyMultiple(i2, i3, keyEvent) : invokeIIL.booleanValue;
    }

    public boolean zeusSuperOnKeyShortcut(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048903, this, i2, keyEvent)) == null) ? super.onKeyShortcut(i2, keyEvent) : invokeIL.booleanValue;
    }

    public boolean zeusSuperOnKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048904, this, i2, keyEvent)) == null) ? super.onKeyUp(i2, keyEvent) : invokeIL.booleanValue;
    }

    public void zeusSuperOnLocalVoiceInteractionStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048905, this) == null) {
            super.onLocalVoiceInteractionStarted();
        }
    }

    public void zeusSuperOnLocalVoiceInteractionStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048906, this) == null) {
            super.onLocalVoiceInteractionStopped();
        }
    }

    public void zeusSuperOnLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048907, this) == null) {
            super.onLowMemory();
        }
    }

    public boolean zeusSuperOnMenuOpened(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048908, this, i2, menu)) == null) ? super.onMenuOpened(i2, menu) : invokeIL.booleanValue;
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048909, this, z) == null) {
            super.onMultiWindowModeChanged(z);
        }
    }

    public boolean zeusSuperOnNavigateUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048911, this)) == null) ? super.onNavigateUp() : invokeV.booleanValue;
    }

    public boolean zeusSuperOnNavigateUpFromChild(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048912, this, activity)) == null) ? super.onNavigateUpFromChild(activity) : invokeL.booleanValue;
    }

    public void zeusSuperOnNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048913, this, intent) == null) {
            super.onNewIntent(intent);
        }
    }

    public boolean zeusSuperOnOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048914, this, menuItem)) == null) ? super.onOptionsItemSelected(menuItem) : invokeL.booleanValue;
    }

    public void zeusSuperOnOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048915, this, menu) == null) {
            super.onOptionsMenuClosed(menu);
        }
    }

    public void zeusSuperOnPanelClosed(int i2, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048916, this, i2, menu) == null) {
            super.onPanelClosed(i2, menu);
        }
    }

    public void zeusSuperOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048917, this) == null) {
            super.onPause();
        }
    }

    public void zeusSuperOnPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048918, this, str, bundle, cancellationSignal, consumer) == null) {
            super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048919, this, z) == null) {
            super.onPictureInPictureModeChanged(z);
        }
    }

    public boolean zeusSuperOnPictureInPictureRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048921, this)) == null) ? super.onPictureInPictureRequested() : invokeV.booleanValue;
    }

    public void zeusSuperOnPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048922, this, bundle) == null) {
            super.onPostCreate(bundle);
        }
    }

    public void zeusSuperOnPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048924, this) == null) {
            super.onPostResume();
        }
    }

    public void zeusSuperOnPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048925, this, i2, dialog) == null) {
            super.onPrepareDialog(i2, dialog);
        }
    }

    public void zeusSuperOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048927, this, taskStackBuilder) == null) {
            super.onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    public boolean zeusSuperOnPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048928, this, menu)) == null) ? super.onPrepareOptionsMenu(menu) : invokeL.booleanValue;
    }

    public boolean zeusSuperOnPreparePanel(int i2, View view, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048929, this, i2, view, menu)) == null) ? super.onPreparePanel(i2, view, menu) : invokeILL.booleanValue;
    }

    public void zeusSuperOnProvideAssistContent(AssistContent assistContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048930, this, assistContent) == null) {
            super.onProvideAssistContent(assistContent);
        }
    }

    public void zeusSuperOnProvideAssistData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048931, this, bundle) == null) {
            super.onProvideAssistData(bundle);
        }
    }

    public void zeusSuperOnProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048932, this, list, menu, i2) == null) {
            super.onProvideKeyboardShortcuts(list, menu, i2);
        }
    }

    public Uri zeusSuperOnProvideReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048933, this)) == null) ? super.onProvideReferrer() : (Uri) invokeV.objValue;
    }

    public void zeusSuperOnRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048934, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public void zeusSuperOnRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048935, this) == null) {
            super.onRestart();
        }
    }

    public void zeusSuperOnRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048936, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    public void zeusSuperOnResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048938, this) == null) {
            super.onResume();
        }
    }

    public void zeusSuperOnSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048939, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public boolean zeusSuperOnSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048941, this)) == null) ? super.onSearchRequested() : invokeV.booleanValue;
    }

    public void zeusSuperOnStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048943, this) == null) {
            super.onStart();
        }
    }

    public void zeusSuperOnStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048944, this) == null) {
            super.onStateNotSaved();
        }
    }

    public void zeusSuperOnStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048945, this) == null) {
            super.onStop();
        }
    }

    public void zeusSuperOnTitleChanged(CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048946, this, charSequence, i2) == null) {
            super.onTitleChanged(charSequence, i2);
        }
    }

    public void zeusSuperOnTopResumedActivityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048947, this, z) == null) {
            super.onTopResumedActivityChanged(z);
        }
    }

    public boolean zeusSuperOnTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048948, this, motionEvent)) == null) ? super.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public boolean zeusSuperOnTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048949, this, motionEvent)) == null) ? super.onTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    public void zeusSuperOnTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048950, this, i2) == null) {
            super.onTrimMemory(i2);
        }
    }

    public void zeusSuperOnUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048951, this) == null) {
            super.onUserInteraction();
        }
    }

    public void zeusSuperOnUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048952, this) == null) {
            super.onUserLeaveHint();
        }
    }

    public void zeusSuperOnVisibleBehindCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048953, this) == null) {
            super.onVisibleBehindCanceled();
        }
    }

    public void zeusSuperOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048954, this, layoutParams) == null) {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    public void zeusSuperOnWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048955, this, z) == null) {
            super.onWindowFocusChanged(z);
        }
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048956, this, callback)) == null) ? super.onWindowStartingActionMode(callback) : (ActionMode) invokeL.objValue;
    }

    public void zeusSuperOpenContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048958, this, view) == null) {
            super.openContextMenu(view);
        }
    }

    public void zeusSuperOpenOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048959, this) == null) {
            super.openOptionsMenu();
        }
    }

    public void zeusSuperOverridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048960, this, i2, i3) == null) {
            super.overridePendingTransition(i2, i3);
        }
    }

    public void zeusSuperPostponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048961, this) == null) {
            super.postponeEnterTransition();
        }
    }

    public void zeusSuperRecreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048962, this) == null) {
            super.recreate();
        }
    }

    public void zeusSuperRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048963, this, activityLifecycleCallbacks) == null) {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void zeusSuperRegisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048964, this, view) == null) {
            super.registerForContextMenu(view);
        }
    }

    public boolean zeusSuperReleaseInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048965, this)) == null) ? super.releaseInstance() : invokeV.booleanValue;
    }

    public void zeusSuperReportFullyDrawn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048966, this) == null) {
            super.reportFullyDrawn();
        }
    }

    public DragAndDropPermissions zeusSuperRequestDragAndDropPermissions(DragEvent dragEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048967, this, dragEvent)) == null) ? super.requestDragAndDropPermissions(dragEvent) : (DragAndDropPermissions) invokeL.objValue;
    }

    public boolean zeusSuperRequestVisibleBehind(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048968, this, z)) == null) ? super.requestVisibleBehind(z) : invokeZ.booleanValue;
    }

    public void zeusSuperSetActionBar(Toolbar toolbar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048969, this, toolbar) == null) {
            super.setActionBar(toolbar);
        }
    }

    public void zeusSuperSetContentTransitionManager(TransitionManager transitionManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048970, this, transitionManager) == null) {
            super.setContentTransitionManager(transitionManager);
        }
    }

    public void zeusSuperSetContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048971, this, i2) == null) {
            super.setContentView(i2);
        }
    }

    public void zeusSuperSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048974, this, sharedElementCallback) == null) {
            super.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    public void zeusSuperSetExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048975, this, sharedElementCallback) == null) {
            super.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    public void zeusSuperSetFinishOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048976, this, z) == null) {
            super.setFinishOnTouchOutside(z);
        }
    }

    public void zeusSuperSetImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048977, this, z) == null) {
            super.setImmersive(z);
        }
    }

    public void zeusSuperSetInheritShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048978, this, z) == null) {
            super.setInheritShowWhenLocked(z);
        }
    }

    public void zeusSuperSetIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048979, this, intent) == null) {
            super.setIntent(intent);
        }
    }

    public void zeusSuperSetLocusContext(LocusId locusId, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048980, this, locusId, bundle) == null) {
            super.setLocusContext(locusId, bundle);
        }
    }

    public void zeusSuperSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048981, this, pictureInPictureParams) == null) {
            super.setPictureInPictureParams(pictureInPictureParams);
        }
    }

    public void zeusSuperSetRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048982, this, i2) == null) {
            super.setRequestedOrientation(i2);
        }
    }

    public void zeusSuperSetShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048983, this, z) == null) {
            super.setShowWhenLocked(z);
        }
    }

    public void zeusSuperSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048984, this, taskDescription) == null) {
            super.setTaskDescription(taskDescription);
        }
    }

    @Override // com.bytedance.pangle.activity.b
    public void zeusSuperSetTheme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048985, this, i2) == null) {
            super.setTheme(i2);
        }
    }

    public void zeusSuperSetTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048986, this, i2) == null) {
            super.setTitle(i2);
        }
    }

    public void zeusSuperSetTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048988, this, i2) == null) {
            super.setTitleColor(i2);
        }
    }

    public boolean zeusSuperSetTranslucent(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048989, this, z)) == null) ? super.setTranslucent(z) : invokeZ.booleanValue;
    }

    public void zeusSuperSetTurnScreenOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048990, this, z) == null) {
            super.setTurnScreenOn(z);
        }
    }

    public void zeusSuperSetVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048991, this, z) == null) {
            super.setVisible(z);
        }
    }

    public void zeusSuperSetVrModeEnabled(boolean z, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048992, this, z, componentName) == null) {
            super.setVrModeEnabled(z, componentName);
        }
    }

    public boolean zeusSuperShouldShowRequestPermissionRationale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048993, this, str)) == null) ? super.shouldShowRequestPermissionRationale(str) : invokeL.booleanValue;
    }

    public boolean zeusSuperShouldUpRecreateTask(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048994, this, intent)) == null) ? super.shouldUpRecreateTask(intent) : invokeL.booleanValue;
    }

    public boolean zeusSuperShowAssist(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048995, this, bundle)) == null) ? super.showAssist(bundle) : invokeL.booleanValue;
    }

    public void zeusSuperShowLockTaskEscapeMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048996, this) == null) {
            super.showLockTaskEscapeMessage();
        }
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048997, this, callback)) == null) ? super.startActionMode(callback) : (ActionMode) invokeL.objValue;
    }

    public void zeusSuperStartActivities(Intent[] intentArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048999, this, intentArr) == null) {
            super.startActivities(intentArr);
        }
    }

    public void zeusSuperStartActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049001, this, intent) == null) {
            super.startActivity(intent);
        }
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1049003, this, intent, i2) == null) {
            super.startActivityForResult(intent, i2);
        }
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1049005, this, activity, intent, i2) == null) {
            super.startActivityFromChild(activity, intent, i2);
        }
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1049007, this, fragment, intent, i2) == null) {
            super.startActivityFromFragment(fragment, intent, i2);
        }
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1049009, this, intent, i2)) == null) ? super.startActivityIfNeeded(intent, i2) : invokeLI.booleanValue;
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049011, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.startIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049013, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049015, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
        }
    }

    public void zeusSuperStartLocalVoiceInteraction(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049017, this, bundle) == null) {
            super.startLocalVoiceInteraction(bundle);
        }
    }

    public void zeusSuperStartLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049018, this) == null) {
            super.startLockTask();
        }
    }

    public void zeusSuperStartManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049019, this, cursor) == null) {
            super.startManagingCursor(cursor);
        }
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1049020, this, intent)) == null) ? super.startNextMatchingActivity(intent) : invokeL.booleanValue;
    }

    public void zeusSuperStartPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049022, this) == null) {
            super.startPostponedEnterTransition();
        }
    }

    public void zeusSuperStartSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049023, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            super.startSearch(str, z, bundle, z2);
        }
    }

    public void zeusSuperStopLocalVoiceInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049024, this) == null) {
            super.stopLocalVoiceInteraction();
        }
    }

    public void zeusSuperStopLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1049025, this) == null) {
            super.stopLockTask();
        }
    }

    public void zeusSuperStopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049026, this, cursor) == null) {
            super.stopManagingCursor(cursor);
        }
    }

    public void zeusSuperTakeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1049027, this, z) == null) {
            super.takeKeyEvents(z);
        }
    }

    public void zeusSuperTriggerSearch(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1049028, this, str, bundle) == null) {
            super.triggerSearch(str, bundle);
        }
    }

    public void zeusSuperUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049029, this, activityLifecycleCallbacks) == null) {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void zeusSuperUnregisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1049030, this, view) == null) {
            super.unregisterForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048655, this, bundle, persistableBundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onCreate(bundle, persistableBundle);
            } else {
                super.onCreate(bundle, persistableBundle);
            }
        }
    }

    public boolean zeusSuperEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048819, this, pictureInPictureParams)) == null) ? super.enterPictureInPictureMode(pictureInPictureParams) : invokeL.booleanValue;
    }

    public void zeusSuperOnCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048883, this, bundle, persistableBundle) == null) {
            super.onCreate(bundle, persistableBundle);
        }
    }

    public Dialog zeusSuperOnCreateDialog(int i2, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048887, this, i2, bundle)) == null) ? super.onCreateDialog(i2, bundle) : (Dialog) invokeIL.objValue;
    }

    public View zeusSuperOnCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048894, this, str, context, attributeSet)) == null) ? super.onCreateView(str, context, attributeSet) : (View) invokeLLL.objValue;
    }

    public void zeusSuperOnMultiWindowModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048910, this, z, configuration) == null) {
            super.onMultiWindowModeChanged(z, configuration);
        }
    }

    public void zeusSuperOnPictureInPictureModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048920, this, z, configuration) == null) {
            super.onPictureInPictureModeChanged(z, configuration);
        }
    }

    public void zeusSuperOnPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048923, this, bundle, persistableBundle) == null) {
            super.onPostCreate(bundle, persistableBundle);
        }
    }

    public void zeusSuperOnPrepareDialog(int i2, Dialog dialog, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048926, this, i2, dialog, bundle) == null) {
            super.onPrepareDialog(i2, dialog, bundle);
        }
    }

    public void zeusSuperOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048937, this, bundle, persistableBundle) == null) {
            super.onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    public void zeusSuperOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048940, this, bundle, persistableBundle) == null) {
            super.onSaveInstanceState(bundle, persistableBundle);
        }
    }

    public boolean zeusSuperOnSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048942, this, searchEvent)) == null) ? super.onSearchRequested(searchEvent) : invokeL.booleanValue;
    }

    public ActionMode zeusSuperOnWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048957, this, callback, i2)) == null) ? super.onWindowStartingActionMode(callback, i2) : (ActionMode) invokeLI.objValue;
    }

    public void zeusSuperSetContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048972, this, view) == null) {
            super.setContentView(view);
        }
    }

    public void zeusSuperSetTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048987, this, charSequence) == null) {
            super.setTitle(charSequence);
        }
    }

    public ActionMode zeusSuperStartActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048998, this, callback, i2)) == null) ? super.startActionMode(callback, i2) : (ActionMode) invokeLI.objValue;
    }

    public void zeusSuperStartActivities(Intent[] intentArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1049000, this, intentArr, bundle) == null) {
            super.startActivities(intentArr, bundle);
        }
    }

    public void zeusSuperStartActivity(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1049002, this, intent, bundle) == null) {
            super.startActivity(intent, bundle);
        }
    }

    public void zeusSuperStartActivityForResult(Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1049004, this, intent, i2, bundle) == null) {
            super.startActivityForResult(intent, i2, bundle);
        }
    }

    public void zeusSuperStartActivityFromChild(Activity activity, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1049006, this, activity, intent, i2, bundle) == null) {
            super.startActivityFromChild(activity, intent, i2, bundle);
        }
    }

    public void zeusSuperStartActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1049008, this, fragment, intent, i2, bundle) == null) {
            super.startActivityFromFragment(fragment, intent, i2, bundle);
        }
    }

    public boolean zeusSuperStartActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1049010, this, intent, i2, bundle)) == null) ? super.startActivityIfNeeded(intent, i2, bundle) : invokeLIL.booleanValue;
    }

    public void zeusSuperStartIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049012, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            super.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
        }
    }

    public void zeusSuperStartIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049014, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    public void zeusSuperStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1049016, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    public boolean zeusSuperStartNextMatchingActivity(Intent intent, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1049021, this, intent, bundle)) == null) ? super.startNextMatchingActivity(intent, bundle) : invokeLL.booleanValue;
    }

    public void zeusSuperSetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048973, this, view, layoutParams) == null) {
            super.setContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pictureInPictureParams)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.enterPictureInPictureMode(pictureInPictureParams);
            }
            return super.enterPictureInPictureMode(pictureInPictureParams);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048659, this, i2, bundle)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreateDialog(i2, bundle);
            }
            return super.onCreateDialog(i2, bundle);
        }
        return (Dialog) invokeIL.objValue;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048666, this, str, context, attributeSet)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onCreateView(str, context, attributeSet);
            }
            return super.onCreateView(str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048682, this, z, configuration) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onMultiWindowModeChanged(z, configuration);
            } else {
                super.onMultiWindowModeChanged(z, configuration);
            }
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048692, this, z, configuration) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPictureInPictureModeChanged(z, configuration);
            } else {
                super.onPictureInPictureModeChanged(z, configuration);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048695, this, bundle, persistableBundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPostCreate(bundle, persistableBundle);
            } else {
                super.onPostCreate(bundle, persistableBundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048698, this, i2, dialog, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onPrepareDialog(i2, dialog, bundle);
            } else {
                super.onPrepareDialog(i2, dialog, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048709, this, bundle, persistableBundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onRestoreInstanceState(bundle, persistableBundle);
            } else {
                super.onRestoreInstanceState(bundle, persistableBundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048712, this, bundle, persistableBundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.onSaveInstanceState(bundle, persistableBundle);
            } else {
                super.onSaveInstanceState(bundle, persistableBundle);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048714, this, searchEvent)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onSearchRequested(searchEvent);
            }
            return super.onSearchRequested(searchEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048729, this, callback, i2)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.onWindowStartingActionMode(callback, i2);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
        return (ActionMode) invokeLI.objValue;
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, view) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setContentView(view);
            } else {
                super.setContentView(view);
            }
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, charSequence) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setTitle(charSequence);
            } else {
                super.setTitle(charSequence);
            }
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048772, this, callback, i2)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.startActionMode(callback, i2);
            }
            return super.startActionMode(callback, i2);
        }
        return (ActionMode) invokeLI.objValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048774, this, intentArr, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivities(intentArr, bundle);
            } else {
                super.startActivities(intentArr, bundle);
            }
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048776, this, intent, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivity(intent, bundle);
            } else {
                super.startActivity(intent, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048778, this, intent, i2, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivityForResult(intent, i2, bundle);
            } else {
                super.startActivityForResult(intent, i2, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048780, this, activity, intent, i2, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivityFromChild(activity, intent, i2, bundle);
            } else {
                super.startActivityFromChild(activity, intent, i2, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048782, this, fragment, intent, i2, bundle) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startActivityFromFragment(fragment, intent, i2, bundle);
            } else {
                super.startActivityFromFragment(fragment, intent, i2, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048784, this, intent, i2, bundle)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.startActivityIfNeeded(intent, i2, bundle);
            }
            return super.startActivityIfNeeded(intent, i2, bundle);
        }
        return invokeLIL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048786, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
            } else {
                super.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048788, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
            } else {
                super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048790, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
            } else {
                super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
            }
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048795, this, intent, bundle)) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                return generatePluginActivity.startNextMatchingActivity(intent, bundle);
            }
            return super.startNextMatchingActivity(intent, bundle);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048745, this, view, layoutParams) == null) {
            GeneratePluginActivity generatePluginActivity = this.mTargetActivity;
            if (generatePluginActivity != null) {
                generatePluginActivity.setContentView(view, layoutParams);
            } else {
                super.setContentView(view, layoutParams);
            }
        }
    }
}
