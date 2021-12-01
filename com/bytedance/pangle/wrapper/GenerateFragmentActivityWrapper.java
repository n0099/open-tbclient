package com.bytedance.pangle.wrapper;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
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
import androidx.core.app.ComponentActivity;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.PluginContext;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;
@Keep
/* loaded from: classes12.dex */
public abstract class GenerateFragmentActivityWrapper extends FragmentActivity implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FragmentActivity mOriginActivity;
    public PluginContext pluginContext;

    public GenerateFragmentActivityWrapper() {
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
            this.mOriginActivity.addContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mOriginActivity.closeContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mOriginActivity.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), intent, Integer.valueOf(i3)})) == null) ? this.mOriginActivity.createPendingResult(i2, intent, i3) : (PendingIntent) invokeCommon.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) ? this.mOriginActivity.dispatchGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, keyEvent)) == null) ? this.mOriginActivity.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) ? this.mOriginActivity.dispatchKeyShortcutEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, accessibilityEvent)) == null) ? this.mOriginActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) ? this.mOriginActivity.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) ? this.mOriginActivity.dispatchTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, str, fileDescriptor, printWriter, strArr) == null) {
            this.mOriginActivity.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mOriginActivity.enterPictureInPictureMode();
        }
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? this.mOriginActivity.findViewById(i2) : (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mOriginActivity.finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mOriginActivity.finishActivity(i2);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, activity, i2) == null) {
            this.mOriginActivity.finishActivityFromChild(activity, i2);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mOriginActivity.finishAffinity();
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mOriginActivity.finishAfterTransition();
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.mOriginActivity.finishAndRemoveTask();
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, activity) == null) {
            this.mOriginActivity.finishFromChild(activity);
        }
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mOriginActivity.getActionBar() : (ActionBar) invokeV.objValue;
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mOriginActivity.getCallingActivity() : (ComponentName) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mOriginActivity.getCallingPackage() : (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mOriginActivity.getChangingConfigurations() : invokeV.intValue;
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mOriginActivity.getComponentName() : (ComponentName) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mOriginActivity.getContentScene() : (Scene) invokeV.objValue;
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mOriginActivity.getContentTransitionManager() : (TransitionManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mOriginActivity.getCurrentFocus() : (View) invokeV.objValue;
    }

    @Override // androidx.core.app.ComponentActivity
    public ComponentActivity.ExtraData getExtraData(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cls)) == null) ? this.mOriginActivity.getExtraData(cls) : (ComponentActivity.ExtraData) invokeL.objValue;
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mOriginActivity.getFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mOriginActivity.getIntent() : (Intent) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mOriginActivity.getLastNonConfigurationInstance() : invokeV.objValue;
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mOriginActivity.getLayoutInflater() : (LayoutInflater) invokeV.objValue;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mOriginActivity.getLifecycle() : (Lifecycle) invokeV.objValue;
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mOriginActivity.getLoaderManager() : (LoaderManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mOriginActivity.getLocalClassName() : (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mOriginActivity.getMaxNumPictureInPictureActions() : invokeV.intValue;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mOriginActivity.getMenuInflater() : (MenuInflater) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mOriginActivity.getParentActivityIntent() : (Intent) invokeV.objValue;
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) ? this.mOriginActivity.getPreferences(i2) : (SharedPreferences) invokeI.objValue;
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mOriginActivity.getReferrer() : (Uri) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mOriginActivity.getRequestedOrientation() : invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mOriginActivity.getSupportFragmentManager() : (androidx.fragment.app.FragmentManager) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.loader.app.LoaderManager getSupportLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mOriginActivity.getSupportLoaderManager() : (androidx.loader.app.LoaderManager) invokeV.objValue;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) ? this.pluginContext.getSystemService(str) : invokeL.objValue;
    }

    @Override // android.app.Activity
    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mOriginActivity.getTaskId() : invokeV.intValue;
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mOriginActivity.getViewModelStore() : (ViewModelStore) invokeV.objValue;
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mOriginActivity.getVoiceInteractor() : (VoiceInteractor) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mOriginActivity.getWindow() : (Window) invokeV.objValue;
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mOriginActivity.getWindowManager() : (WindowManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mOriginActivity.hasWindowFocus() : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mOriginActivity.hashCode() : invokeV.intValue;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.mOriginActivity.invalidateOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mOriginActivity.isActivityTransitionRunning() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mOriginActivity.isChangingConfigurations() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mOriginActivity.isDestroyed() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mOriginActivity.isFinishing() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mOriginActivity.isImmersive() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mOriginActivity.isInMultiWindowMode() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mOriginActivity.isInPictureInPictureMode() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mOriginActivity.isLocalVoiceInteractionSupported() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.mOriginActivity.isTaskRoot() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mOriginActivity.isVoiceInteraction() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mOriginActivity.isVoiceInteractionRoot() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048641, this, z)) == null) ? this.mOriginActivity.moveTaskToBack(z) : invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, intent)) == null) ? this.mOriginActivity.navigateUpTo(intent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048643, this, activity, intent)) == null) ? this.mOriginActivity.navigateUpToFromChild(activity, intent) : invokeLL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, actionMode) == null) {
            this.mOriginActivity.onActionModeFinished(actionMode);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, actionMode) == null) {
            this.mOriginActivity.onActionModeStarted(actionMode);
        }
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048646, this, i2, intent) == null) {
            this.mOriginActivity.onActivityReenter(i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, fragment) == null) {
            this.mOriginActivity.onAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.mOriginActivity.onAttachedToWindow();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.mOriginActivity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, configuration) == null) {
            this.mOriginActivity.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            this.mOriginActivity.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, menuItem)) == null) ? this.mOriginActivity.onContextItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, menu) == null) {
            this.mOriginActivity.onContextMenuClosed(menu);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, bundle) == null) {
            super.onCreate(bundle);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048656, this, bundle, persistableBundle) == null) {
            this.mOriginActivity.onCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048657, this, contextMenu, view, contextMenuInfo) == null) {
            this.mOriginActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.mOriginActivity.onCreateDescription() : (CharSequence) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, taskStackBuilder) == null) {
            this.mOriginActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, menu)) == null) ? this.mOriginActivity.onCreateOptionsMenu(menu) : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048661, this, i2, menu)) == null) ? this.mOriginActivity.onCreatePanelMenu(i2, menu) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048662, this, i2)) == null) ? this.mOriginActivity.onCreatePanelView(i2) : (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048663, this, bitmap, canvas)) == null) ? this.mOriginActivity.onCreateThumbnail(bitmap, canvas) : invokeLL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048665, this, str, context, attributeSet)) == null) ? this.mOriginActivity.onCreateView(str, context, attributeSet) : (View) invokeLLL.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            this.mOriginActivity.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            this.mOriginActivity.onEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, motionEvent)) == null) ? this.mOriginActivity.onGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048669, this, cancellationSignal, consumer) == null) {
            this.mOriginActivity.onGetDirectActions(cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048670, this, i2, keyEvent)) == null) ? this.mOriginActivity.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048671, this, i2, keyEvent)) == null) ? this.mOriginActivity.onKeyLongPress(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048672, this, i2, i3, keyEvent)) == null) ? this.mOriginActivity.onKeyMultiple(i2, i3, keyEvent) : invokeIIL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048673, this, i2, keyEvent)) == null) ? this.mOriginActivity.onKeyShortcut(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048674, this, i2, keyEvent)) == null) ? this.mOriginActivity.onKeyUp(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.mOriginActivity.onLocalVoiceInteractionStarted();
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            this.mOriginActivity.onLocalVoiceInteractionStopped();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            this.mOriginActivity.onLowMemory();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048678, this, i2, menuItem)) == null) ? this.mOriginActivity.onMenuItemSelected(i2, menuItem) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048679, this, i2, menu)) == null) ? this.mOriginActivity.onMenuOpened(i2, menu) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048681, this, z, configuration) == null) {
            this.mOriginActivity.onMultiWindowModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.mOriginActivity.onNavigateUp() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048683, this, activity)) == null) ? this.mOriginActivity.onNavigateUpFromChild(activity) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048684, this, menuItem)) == null) ? this.mOriginActivity.onOptionsItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, menu) == null) {
            this.mOriginActivity.onOptionsMenuClosed(menu);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048686, this, i2, menu) == null) {
            this.mOriginActivity.onPanelClosed(i2, menu);
        }
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048687, this, str, bundle, cancellationSignal, consumer) == null) {
            this.mOriginActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048689, this, z, configuration) == null) {
            this.mOriginActivity.onPictureInPictureModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.mOriginActivity.onPictureInPictureRequested() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048691, this, bundle, persistableBundle) == null) {
            this.mOriginActivity.onPostCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, taskStackBuilder) == null) {
            this.mOriginActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, menu)) == null) ? this.mOriginActivity.onPrepareOptionsMenu(menu) : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048694, this, i2, view, menu)) == null) ? this.mOriginActivity.onPreparePanel(i2, view, menu) : invokeILL.booleanValue;
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, assistContent) == null) {
            this.mOriginActivity.onProvideAssistContent(assistContent);
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, bundle) == null) {
            this.mOriginActivity.onProvideAssistData(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048697, this, list, menu, i2) == null) {
            this.mOriginActivity.onProvideKeyboardShortcuts(list, menu, i2);
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? this.mOriginActivity.onProvideReferrer() : (Uri) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048699, this, i2, strArr, iArr) == null) {
            this.mOriginActivity.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048700, this, bundle, persistableBundle) == null) {
            this.mOriginActivity.onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048701, this, bundle, persistableBundle) == null) {
            this.mOriginActivity.onSaveInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048703, this, searchEvent)) == null) ? this.mOriginActivity.onSearchRequested(searchEvent) : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            this.mOriginActivity.onStateNotSaved();
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z) == null) {
            this.mOriginActivity.onTopResumedActivityChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048706, this, motionEvent)) == null) ? this.mOriginActivity.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, motionEvent)) == null) ? this.mOriginActivity.onTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048708, this, i2) == null) {
            this.mOriginActivity.onTrimMemory(i2);
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            this.mOriginActivity.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            this.mOriginActivity.onVisibleBehindCanceled();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, layoutParams) == null) {
            this.mOriginActivity.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z) == null) {
            this.mOriginActivity.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, callback)) == null) ? this.mOriginActivity.onWindowStartingActionMode(callback) : (ActionMode) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, view) == null) {
            this.mOriginActivity.openContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            this.mOriginActivity.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048717, this, i2, i3) == null) {
            this.mOriginActivity.overridePendingTransition(i2, i3);
        }
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            this.mOriginActivity.postponeEnterTransition();
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public void putExtraData(ComponentActivity.ExtraData extraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, extraData) == null) {
            this.mOriginActivity.putExtraData(extraData);
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.mOriginActivity.recreate();
        }
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, activityLifecycleCallbacks) == null) {
            this.mOriginActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, view) == null) {
            this.mOriginActivity.registerForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) ? this.mOriginActivity.releaseInstance() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            this.mOriginActivity.reportFullyDrawn();
        }
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048725, this, dragEvent)) == null) ? this.mOriginActivity.requestDragAndDropPermissions(dragEvent) : (DragAndDropPermissions) invokeL.objValue;
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048726, this, z)) == null) ? this.mOriginActivity.requestVisibleBehind(z) : invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, toolbar) == null) {
            this.mOriginActivity.setActionBar(toolbar);
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, transitionManager) == null) {
            this.mOriginActivity.setContentTransitionManager(transitionManager);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048729, this, i2) == null) {
            this.mOriginActivity.setContentView(i2);
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, sharedElementCallback) == null) {
            this.mOriginActivity.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, sharedElementCallback) == null) {
            this.mOriginActivity.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z) == null) {
            this.mOriginActivity.setFinishOnTouchOutside(z);
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z) == null) {
            this.mOriginActivity.setImmersive(z);
        }
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z) == null) {
            this.mOriginActivity.setInheritShowWhenLocked(z);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, intent) == null) {
            this.mOriginActivity.setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048740, this, locusId, bundle) == null) {
            this.mOriginActivity.setLocusContext(locusId, bundle);
        }
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, pictureInPictureParams) == null) {
            this.mOriginActivity.setPictureInPictureParams(pictureInPictureParams);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048742, this, i2) == null) {
            this.mOriginActivity.setRequestedOrientation(i2);
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z) == null) {
            this.mOriginActivity.setShowWhenLocked(z);
        }
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, taskDescription) == null) {
            this.mOriginActivity.setTaskDescription(taskDescription);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048745, this, i2) == null) {
            this.mOriginActivity.setTheme(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, charSequence) == null) {
            this.mOriginActivity.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048748, this, i2) == null) {
            this.mOriginActivity.setTitleColor(i2);
        }
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048749, this, z)) == null) ? this.mOriginActivity.setTranslucent(z) : invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z) == null) {
            this.mOriginActivity.setTurnScreenOn(z);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z) == null) {
            this.mOriginActivity.setVisible(z);
        }
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048752, this, z, componentName) == null) {
            this.mOriginActivity.setVrModeEnabled(z, componentName);
        }
    }

    @Override // com.bytedance.pangle.wrapper.a
    public void setWrapperActivityTheme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i2) == null) {
            try {
                super.setTheme(i2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048754, this, str)) == null) ? this.mOriginActivity.shouldShowRequestPermissionRationale(str) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048755, this, intent)) == null) ? this.mOriginActivity.shouldUpRecreateTask(intent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048756, this, bundle)) == null) ? this.mOriginActivity.showAssist(bundle) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            this.mOriginActivity.showLockTaskEscapeMessage();
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048758, this, callback)) == null) ? this.mOriginActivity.startActionMode(callback) : (ActionMode) invokeL.objValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, intentArr) == null) {
            this.mOriginActivity.startActivities(intentArr);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, intent) == null) {
            this.mOriginActivity.startActivity(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048764, this, intent, i2) == null) {
            this.mOriginActivity.startActivityForResult(intent, i2);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048766, this, activity, intent, i2) == null) {
            this.mOriginActivity.startActivityFromChild(activity, intent, i2);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048768, this, fragment, intent, i2) == null) {
            this.mOriginActivity.startActivityFromFragment(fragment, intent, i2);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048772, this, intent, i2)) == null) ? this.mOriginActivity.startActivityIfNeeded(intent, i2) : invokeLI.booleanValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048774, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mOriginActivity.startIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048776, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mOriginActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048778, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mOriginActivity.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startIntentSenderFromFragment(androidx.fragment.app.Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048780, this, new Object[]{fragment, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            this.mOriginActivity.startIntentSenderFromFragment(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048781, this, bundle) == null) {
            this.mOriginActivity.startLocalVoiceInteraction(bundle);
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            this.mOriginActivity.startLockTask();
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, cursor) == null) {
            this.mOriginActivity.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048784, this, intent)) == null) ? this.mOriginActivity.startNextMatchingActivity(intent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            this.mOriginActivity.startPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048787, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            this.mOriginActivity.startSearch(str, z, bundle, z2);
        }
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048788, this) == null) {
            this.mOriginActivity.stopLocalVoiceInteraction();
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048789, this) == null) {
            this.mOriginActivity.stopLockTask();
        }
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048790, this, cursor) == null) {
            this.mOriginActivity.stopManagingCursor(cursor);
        }
    }

    @Override // androidx.core.app.ComponentActivity, androidx.core.view.KeyEventDispatcher.Component
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048791, this, keyEvent)) == null) ? this.mOriginActivity.superDispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportFinishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048792, this) == null) {
            this.mOriginActivity.supportFinishAfterTransition();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048793, this) == null) {
            this.mOriginActivity.supportInvalidateOptionsMenu();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportPostponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            this.mOriginActivity.supportPostponeEnterTransition();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportStartPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048795, this) == null) {
            this.mOriginActivity.supportStartPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048796, this, z) == null) {
            this.mOriginActivity.takeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048797, this, str, bundle) == null) {
            this.mOriginActivity.triggerSearch(str, bundle);
        }
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048798, this, activityLifecycleCallbacks) == null) {
            this.mOriginActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, view) == null) {
            this.mOriginActivity.unregisterForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pictureInPictureParams)) == null) ? this.mOriginActivity.enterPictureInPictureMode(pictureInPictureParams) : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(androidx.fragment.app.Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, fragment) == null) {
            this.mOriginActivity.onAttachFragment(fragment);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048664, this, view, str, context, attributeSet)) == null) ? this.mOriginActivity.onCreateView(view, str, context, attributeSet) : (View) invokeLLLL.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z) == null) {
            this.mOriginActivity.onMultiWindowModeChanged(z);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048688, this, z) == null) {
            this.mOriginActivity.onPictureInPictureModeChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.mOriginActivity.onSearchRequested() : invokeV.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048714, this, callback, i2)) == null) ? this.mOriginActivity.onWindowStartingActionMode(callback, i2) : (ActionMode) invokeLI.objValue;
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, view) == null) {
            this.mOriginActivity.setContentView(view);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void setEnterSharedElementCallback(androidx.core.app.SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, sharedElementCallback) == null) {
            this.mOriginActivity.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void setExitSharedElementCallback(androidx.core.app.SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, sharedElementCallback) == null) {
            this.mOriginActivity.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048746, this, i2) == null) {
            this.mOriginActivity.setTitle(i2);
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048759, this, callback, i2)) == null) ? this.mOriginActivity.startActionMode(callback, i2) : (ActionMode) invokeLI.objValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048761, this, intentArr, bundle) == null) {
            this.mOriginActivity.startActivities(intentArr, bundle);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048763, this, intent, bundle) == null) {
            this.mOriginActivity.startActivity(intent, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048765, this, intent, i2, bundle) == null) {
            this.mOriginActivity.startActivityForResult(intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048767, this, activity, intent, i2, bundle) == null) {
            this.mOriginActivity.startActivityFromChild(activity, intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048769, this, fragment, intent, i2, bundle) == null) {
            this.mOriginActivity.startActivityFromFragment(fragment, intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048773, this, intent, i2, bundle)) == null) ? this.mOriginActivity.startActivityIfNeeded(intent, i2, bundle) : invokeLIL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048775, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            this.mOriginActivity.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048777, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            this.mOriginActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048779, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            this.mOriginActivity.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048785, this, intent, bundle)) == null) ? this.mOriginActivity.startNextMatchingActivity(intent, bundle) : invokeLL.booleanValue;
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048731, this, view, layoutParams) == null) {
            this.mOriginActivity.setContentView(view, layoutParams);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(androidx.fragment.app.Fragment fragment, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048770, this, fragment, intent, i2) == null) {
            this.mOriginActivity.startActivityFromFragment(fragment, intent, i2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(androidx.fragment.app.Fragment fragment, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048771, this, fragment, intent, i2, bundle) == null) {
            this.mOriginActivity.startActivityFromFragment(fragment, intent, i2, bundle);
        }
    }
}
