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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.plugin.Plugin;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;
@Keep
/* loaded from: classes11.dex */
public abstract class GeneratePluginActivity extends Activity implements IPluginActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Plugin mPlugin;
    public GenerateProxyActivity mProxyActivity;

    public GeneratePluginActivity() {
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

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void _requestPermissions(String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, strArr, i2) == null) {
            this.mProxyActivity.requestPermissions(strArr, i2);
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, layoutParams) == null) {
            this.mProxyActivity.zeusSuperAddContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, com.bytedance.pangle.activity.IPluginActivity
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            super.attachBaseContext(context);
            com.bytedance.pangle.util.a.a(this, this.mProxyActivity);
        }
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mProxyActivity.zeusSuperCloseContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mProxyActivity.zeusSuperCloseOptionsMenu();
        }
    }

    public boolean convertToTranslucent(Activity.TranslucentConversionListener translucentConversionListener, ActivityOptions activityOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, translucentConversionListener, activityOptions)) == null) ? this.mProxyActivity.zeusSuperConvertToTranslucent(translucentConversionListener, activityOptions) : invokeLL.booleanValue;
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), intent, Integer.valueOf(i3)})) == null) ? this.mProxyActivity.zeusSuperCreatePendingResult(i2, intent, i3) : (PendingIntent) invokeCommon.objValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) ? this.mProxyActivity.zeusSuperDispatchGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, keyEvent)) == null) ? this.mProxyActivity.zeusSuperDispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, keyEvent)) == null) ? this.mProxyActivity.zeusSuperDispatchKeyShortcutEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, accessibilityEvent)) == null) ? this.mProxyActivity.zeusSuperDispatchPopulateAccessibilityEvent(accessibilityEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) ? this.mProxyActivity.zeusSuperDispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) ? this.mProxyActivity.zeusSuperDispatchTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, str, fileDescriptor, printWriter, strArr) == null) {
            this.mProxyActivity.zeusSuperDump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mProxyActivity.zeusSuperEnterPictureInPictureMode();
        }
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? this.mProxyActivity.zeusSuperFindViewById(i2) : (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mProxyActivity.zeusSuperFinish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mProxyActivity.zeusSuperFinishActivity(i2);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, activity, i2) == null) {
            this.mProxyActivity.zeusSuperFinishActivityFromChild(activity, i2);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.mProxyActivity.zeusSuperFinishAffinity();
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.mProxyActivity.zeusSuperFinishAfterTransition();
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.mProxyActivity.zeusSuperFinishAndRemoveTask();
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, activity) == null) {
            this.mProxyActivity.zeusSuperFinishFromChild(activity);
        }
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mProxyActivity.zeusSuperGetActionBar() : (ActionBar) invokeV.objValue;
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mProxyActivity.zeusSuperGetCallingActivity() : (ComponentName) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mProxyActivity.zeusSuperGetCallingPackage() : (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mProxyActivity.zeusSuperGetChangingConfigurations() : invokeV.intValue;
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mProxyActivity.zeusSuperGetComponentName() : (ComponentName) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mProxyActivity.zeusSuperGetContentScene() : (Scene) invokeV.objValue;
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mProxyActivity.zeusSuperGetContentTransitionManager() : (TransitionManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mProxyActivity.zeusSuperGetCurrentFocus() : (View) invokeV.objValue;
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mProxyActivity.zeusSuperGetFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mProxyActivity.zeusSuperGetIntent() : (Intent) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mProxyActivity.zeusSuperGetLastNonConfigurationInstance() : invokeV.objValue;
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mProxyActivity.zeusSuperGetLayoutInflater() : (LayoutInflater) invokeV.objValue;
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mProxyActivity.zeusSuperGetLoaderManager() : (LoaderManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mProxyActivity.zeusSuperGetLocalClassName() : (String) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mProxyActivity.zeusSuperGetMaxNumPictureInPictureActions() : invokeV.intValue;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mProxyActivity.zeusSuperGetMenuInflater() : (MenuInflater) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mProxyActivity.zeusSuperGetParentActivityIntent() : (Intent) invokeV.objValue;
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) ? this.mProxyActivity.zeusSuperGetPreferences(i2) : (SharedPreferences) invokeI.objValue;
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mProxyActivity.zeusSuperGetReferrer() : (Uri) invokeV.objValue;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mProxyActivity.zeusSuperGetRequestedOrientation() : invokeV.intValue;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) ? this.mProxyActivity.zeusSuperGetSystemService(str) : invokeL.objValue;
    }

    @Override // android.app.Activity
    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mProxyActivity.zeusSuperGetTaskId() : invokeV.intValue;
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mProxyActivity.zeusSuperGetVoiceInteractor() : (VoiceInteractor) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mProxyActivity.zeusSuperGetWindow() : (Window) invokeV.objValue;
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mProxyActivity.zeusSuperGetWindowManager() : (WindowManager) invokeV.objValue;
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mProxyActivity.zeusSuperHasWindowFocus() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.mProxyActivity.zeusSuperInvalidateOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mProxyActivity.zeusSuperIsActivityTransitionRunning() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mProxyActivity.zeusSuperIsChangingConfigurations() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mProxyActivity.zeusSuperIsDestroyed() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mProxyActivity.zeusSuperIsFinishing() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mProxyActivity.zeusSuperIsImmersive() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mProxyActivity.zeusSuperIsInMultiWindowMode() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mProxyActivity.zeusSuperIsInPictureInPictureMode() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mProxyActivity.zeusSuperIsLocalVoiceInteractionSupported() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mProxyActivity.zeusSuperIsTaskRoot() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mProxyActivity.zeusSuperIsVoiceInteraction() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mProxyActivity.zeusSuperIsVoiceInteractionRoot() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z)) == null) ? this.mProxyActivity.zeusSuperMoveTaskToBack(z) : invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, intent)) == null) ? this.mProxyActivity.zeusSuperNavigateUpTo(intent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048640, this, activity, intent)) == null) ? this.mProxyActivity.zeusSuperNavigateUpToFromChild(activity, intent) : invokeLL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, actionMode) == null) {
            this.mProxyActivity.zeusSuperOnActionModeFinished(actionMode);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, actionMode) == null) {
            this.mProxyActivity.zeusSuperOnActionModeStarted(actionMode);
        }
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i2, intent) == null) {
            this.mProxyActivity.zeusSuperOnActivityReenter(i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048644, this, i2, i3, intent) == null) {
            this.mProxyActivity.zeusSuperOnActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mProxyActivity.zeusSuperOnApplyThemeResource(theme, i2, z);
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, fragment) == null) {
            this.mProxyActivity.zeusSuperOnAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.mProxyActivity.zeusSuperOnAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.mProxyActivity.zeusSuperOnBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, activity, charSequence) == null) {
            this.mProxyActivity.zeusSuperOnChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, configuration) == null) {
            this.mProxyActivity.zeusSuperOnConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.mProxyActivity.zeusSuperOnContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, menuItem)) == null) ? this.mProxyActivity.zeusSuperOnContextItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, menu) == null) {
            this.mProxyActivity.zeusSuperOnContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity, com.bytedance.pangle.activity.IPluginActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, bundle) == null) {
            this.mProxyActivity.zeusSuperOnCreate(bundle);
            com.bytedance.pangle.res.b.a(getLayoutInflater());
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048656, this, contextMenu, view, contextMenuInfo) == null) {
            this.mProxyActivity.zeusSuperOnCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.mProxyActivity.zeusSuperOnCreateDescription() : (CharSequence) invokeV.objValue;
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i2)) == null) ? this.mProxyActivity.zeusSuperOnCreateDialog(i2) : (Dialog) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, taskStackBuilder) == null) {
            this.mProxyActivity.zeusSuperOnCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, menu)) == null) ? this.mProxyActivity.zeusSuperOnCreateOptionsMenu(menu) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048662, this, i2, menu)) == null) ? this.mProxyActivity.zeusSuperOnCreatePanelMenu(i2, menu) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048663, this, i2)) == null) ? this.mProxyActivity.zeusSuperOnCreatePanelView(i2) : (View) invokeI.objValue;
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048664, this, bitmap, canvas)) == null) ? this.mProxyActivity.zeusSuperOnCreateThumbnail(bitmap, canvas) : invokeLL.booleanValue;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048665, this, view, str, context, attributeSet)) == null) ? this.mProxyActivity.zeusSuperOnCreateView(view, str, context, attributeSet) : (View) invokeLLLL.objValue;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            this.mProxyActivity.zeusSuperOnDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            this.mProxyActivity.zeusSuperOnDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            this.mProxyActivity.zeusSuperOnEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, motionEvent)) == null) ? this.mProxyActivity.zeusSuperOnGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048671, this, cancellationSignal, consumer) == null) {
            this.mProxyActivity.zeusSuperOnGetDirectActions(cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048672, this, i2, keyEvent)) == null) ? this.mProxyActivity.zeusSuperOnKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048673, this, i2, keyEvent)) == null) ? this.mProxyActivity.zeusSuperOnKeyLongPress(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048674, this, i2, i3, keyEvent)) == null) ? this.mProxyActivity.zeusSuperOnKeyMultiple(i2, i3, keyEvent) : invokeIIL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048675, this, i2, keyEvent)) == null) ? this.mProxyActivity.zeusSuperOnKeyShortcut(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048676, this, i2, keyEvent)) == null) ? this.mProxyActivity.zeusSuperOnKeyUp(i2, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            this.mProxyActivity.zeusSuperOnLocalVoiceInteractionStarted();
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            this.mProxyActivity.zeusSuperOnLocalVoiceInteractionStopped();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            this.mProxyActivity.zeusSuperOnLowMemory();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048680, this, i2, menu)) == null) ? this.mProxyActivity.zeusSuperOnMenuOpened(i2, menu) : invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z) == null) {
            this.mProxyActivity.zeusSuperOnMultiWindowModeChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.mProxyActivity.zeusSuperOnNavigateUp() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048684, this, activity)) == null) ? this.mProxyActivity.zeusSuperOnNavigateUpFromChild(activity) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, intent) == null) {
            this.mProxyActivity.zeusSuperOnNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, menuItem)) == null) ? this.mProxyActivity.zeusSuperOnOptionsItemSelected(menuItem) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, menu) == null) {
            this.mProxyActivity.zeusSuperOnOptionsMenuClosed(menu);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048688, this, i2, menu) == null) {
            this.mProxyActivity.zeusSuperOnPanelClosed(i2, menu);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            this.mProxyActivity.zeusSuperOnPause();
        }
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048690, this, str, bundle, cancellationSignal, consumer) == null) {
            this.mProxyActivity.zeusSuperOnPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z) == null) {
            this.mProxyActivity.zeusSuperOnPictureInPictureModeChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? this.mProxyActivity.zeusSuperOnPictureInPictureRequested() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, bundle) == null) {
            this.mProxyActivity.zeusSuperOnPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            this.mProxyActivity.zeusSuperOnPostResume();
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048697, this, i2, dialog) == null) {
            this.mProxyActivity.zeusSuperOnPrepareDialog(i2, dialog);
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, taskStackBuilder) == null) {
            this.mProxyActivity.zeusSuperOnPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, menu)) == null) ? this.mProxyActivity.zeusSuperOnPrepareOptionsMenu(menu) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048701, this, i2, view, menu)) == null) ? this.mProxyActivity.zeusSuperOnPreparePanel(i2, view, menu) : invokeILL.booleanValue;
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, assistContent) == null) {
            this.mProxyActivity.zeusSuperOnProvideAssistContent(assistContent);
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, bundle) == null) {
            this.mProxyActivity.zeusSuperOnProvideAssistData(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048704, this, list, menu, i2) == null) {
            this.mProxyActivity.zeusSuperOnProvideKeyboardShortcuts(list, menu, i2);
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.mProxyActivity.zeusSuperOnProvideReferrer() : (Uri) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048706, this, i2, strArr, iArr) == null) {
            this.mProxyActivity.zeusSuperOnRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            this.mProxyActivity.zeusSuperOnRestart();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            this.mProxyActivity.zeusSuperOnRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            this.mProxyActivity.zeusSuperOnResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            this.mProxyActivity.zeusSuperOnSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.mProxyActivity.zeusSuperOnSearchRequested() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            this.mProxyActivity.zeusSuperOnStart();
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            this.mProxyActivity.zeusSuperOnStateNotSaved();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            this.mProxyActivity.zeusSuperOnStop();
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048718, this, charSequence, i2) == null) {
            this.mProxyActivity.zeusSuperOnTitleChanged(charSequence, i2);
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z) == null) {
            this.mProxyActivity.zeusSuperOnTopResumedActivityChanged(z);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048720, this, motionEvent)) == null) ? this.mProxyActivity.zeusSuperOnTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048721, this, motionEvent)) == null) ? this.mProxyActivity.zeusSuperOnTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i2) == null) {
            this.mProxyActivity.zeusSuperOnTrimMemory(i2);
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            this.mProxyActivity.zeusSuperOnUserInteraction();
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            this.mProxyActivity.zeusSuperOnUserLeaveHint();
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            this.mProxyActivity.zeusSuperOnVisibleBehindCanceled();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, layoutParams) == null) {
            this.mProxyActivity.zeusSuperOnWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z) == null) {
            this.mProxyActivity.zeusSuperOnWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048728, this, callback)) == null) ? this.mProxyActivity.zeusSuperOnWindowStartingActionMode(callback) : (ActionMode) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, view) == null) {
            this.mProxyActivity.zeusSuperOpenContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.mProxyActivity.zeusSuperOpenOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048732, this, i2, i3) == null) {
            this.mProxyActivity.zeusSuperOverridePendingTransition(i2, i3);
        }
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            this.mProxyActivity.zeusSuperPostponeEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            this.mProxyActivity.zeusSuperRecreate();
        }
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, activityLifecycleCallbacks) == null) {
            this.mProxyActivity.zeusSuperRegisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, view) == null) {
            this.mProxyActivity.zeusSuperRegisterForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.mProxyActivity.zeusSuperReleaseInstance() : invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            this.mProxyActivity.zeusSuperReportFullyDrawn();
        }
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048739, this, dragEvent)) == null) ? this.mProxyActivity.zeusSuperRequestDragAndDropPermissions(dragEvent) : (DragAndDropPermissions) invokeL.objValue;
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048740, this, z)) == null) ? this.mProxyActivity.zeusSuperRequestVisibleBehind(z) : invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, toolbar) == null) {
            this.mProxyActivity.zeusSuperSetActionBar(toolbar);
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, transitionManager) == null) {
            this.mProxyActivity.zeusSuperSetContentTransitionManager(transitionManager);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i2) == null) {
            this.mProxyActivity.zeusSuperSetContentView(i2);
            c.a(this, findViewById(16908290));
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, sharedElementCallback) == null) {
            this.mProxyActivity.zeusSuperSetEnterSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, sharedElementCallback) == null) {
            this.mProxyActivity.zeusSuperSetExitSharedElementCallback(sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z) == null) {
            this.mProxyActivity.zeusSuperSetFinishOnTouchOutside(z);
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z) == null) {
            this.mProxyActivity.zeusSuperSetImmersive(z);
        }
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z) == null) {
            this.mProxyActivity.zeusSuperSetInheritShowWhenLocked(z);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, intent) == null) {
            this.mProxyActivity.zeusSuperSetIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048752, this, locusId, bundle) == null) {
            this.mProxyActivity.zeusSuperSetLocusContext(locusId, bundle);
        }
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, pictureInPictureParams) == null) {
            this.mProxyActivity.zeusSuperSetPictureInPictureParams(pictureInPictureParams);
        }
    }

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void setPluginProxyActivity(b bVar, Plugin plugin2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048754, this, bVar, plugin2) == null) {
            this.mProxyActivity = (GenerateProxyActivity) bVar;
            this.mPlugin = plugin2;
        }
    }

    @Override // com.bytedance.pangle.activity.IPluginActivity
    public void setProxyTheme2Plugin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048755, this, i2) == null) {
            try {
                super.setTheme(i2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048756, this, i2) == null) {
            this.mProxyActivity.zeusSuperSetRequestedOrientation(i2);
        }
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z) == null) {
            this.mProxyActivity.zeusSuperSetShowWhenLocked(z);
        }
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, taskDescription) == null) {
            this.mProxyActivity.zeusSuperSetTaskDescription(taskDescription);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048759, this, i2) == null) {
            this.mProxyActivity.zeusSuperSetTheme(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048760, this, i2) == null) {
            this.mProxyActivity.zeusSuperSetTitle(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048762, this, i2) == null) {
            this.mProxyActivity.zeusSuperSetTitleColor(i2);
        }
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048763, this, z)) == null) ? this.mProxyActivity.zeusSuperSetTranslucent(z) : invokeZ.booleanValue;
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048764, this, z) == null) {
            this.mProxyActivity.zeusSuperSetTurnScreenOn(z);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048765, this, z) == null) {
            this.mProxyActivity.zeusSuperSetVisible(z);
        }
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048766, this, z, componentName) == null) {
            this.mProxyActivity.zeusSuperSetVrModeEnabled(z, componentName);
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048767, this, str)) == null) ? this.mProxyActivity.zeusSuperShouldShowRequestPermissionRationale(str) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048768, this, intent)) == null) ? this.mProxyActivity.zeusSuperShouldUpRecreateTask(intent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048769, this, bundle)) == null) ? this.mProxyActivity.zeusSuperShowAssist(bundle) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            this.mProxyActivity.zeusSuperShowLockTaskEscapeMessage();
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048771, this, callback)) == null) ? this.mProxyActivity.zeusSuperStartActionMode(callback) : (ActionMode) invokeL.objValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, intentArr) == null) {
            this.mProxyActivity.zeusSuperStartActivities(intentArr);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, intent) == null) {
            this.mProxyActivity.zeusSuperStartActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048777, this, intent, i2) == null) {
            this.mProxyActivity.zeusSuperStartActivityForResult(intent, i2);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048779, this, activity, intent, i2) == null) {
            this.mProxyActivity.zeusSuperStartActivityFromChild(activity, intent, i2);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048781, this, fragment, intent, i2) == null) {
            this.mProxyActivity.zeusSuperStartActivityFromFragment(fragment, intent, i2);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048783, this, intent, i2)) == null) ? this.mProxyActivity.zeusSuperStartActivityIfNeeded(intent, i2) : invokeLI.booleanValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048785, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mProxyActivity.zeusSuperStartIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048787, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mProxyActivity.zeusSuperStartIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048789, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mProxyActivity.zeusSuperStartIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, bundle) == null) {
            this.mProxyActivity.zeusSuperStartLocalVoiceInteraction(bundle);
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048792, this) == null) {
            this.mProxyActivity.zeusSuperStartLockTask();
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, cursor) == null) {
            this.mProxyActivity.zeusSuperStartManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048794, this, intent)) == null) ? this.mProxyActivity.zeusSuperStartNextMatchingActivity(intent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048796, this) == null) {
            this.mProxyActivity.zeusSuperStartPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048797, this, new Object[]{str, Boolean.valueOf(z), bundle, Boolean.valueOf(z2)}) == null) {
            this.mProxyActivity.zeusSuperStartSearch(str, z, bundle, z2);
        }
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            this.mProxyActivity.zeusSuperStopLocalVoiceInteraction();
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            this.mProxyActivity.zeusSuperStopLockTask();
        }
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, cursor) == null) {
            this.mProxyActivity.zeusSuperStopManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            this.mProxyActivity.zeusSuperTakeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048802, this, str, bundle) == null) {
            this.mProxyActivity.zeusSuperTriggerSearch(str, bundle);
        }
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, activityLifecycleCallbacks) == null) {
            this.mProxyActivity.zeusSuperUnregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048804, this, view) == null) {
            this.mProxyActivity.zeusSuperUnregisterForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, pictureInPictureParams)) == null) ? this.mProxyActivity.zeusSuperEnterPictureInPictureMode(pictureInPictureParams) : invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048659, this, i2, bundle)) == null) ? this.mProxyActivity.zeusSuperOnCreateDialog(i2, bundle) : (Dialog) invokeIL.objValue;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048666, this, str, context, attributeSet)) == null) ? this.mProxyActivity.zeusSuperOnCreateView(str, context, attributeSet) : (View) invokeLLL.objValue;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048682, this, z, configuration) == null) {
            this.mProxyActivity.zeusSuperOnMultiWindowModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048692, this, z, configuration) == null) {
            this.mProxyActivity.zeusSuperOnPictureInPictureModeChanged(z, configuration);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048695, this, bundle, persistableBundle) == null) {
            this.mProxyActivity.zeusSuperOnPostCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048698, this, i2, dialog, bundle) == null) {
            this.mProxyActivity.zeusSuperOnPrepareDialog(i2, dialog, bundle);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048709, this, bundle, persistableBundle) == null) {
            this.mProxyActivity.zeusSuperOnRestoreInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048712, this, bundle, persistableBundle) == null) {
            this.mProxyActivity.zeusSuperOnSaveInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048714, this, searchEvent)) == null) ? this.mProxyActivity.zeusSuperOnSearchRequested(searchEvent) : invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048729, this, callback, i2)) == null) ? this.mProxyActivity.zeusSuperOnWindowStartingActionMode(callback, i2) : (ActionMode) invokeLI.objValue;
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, charSequence) == null) {
            this.mProxyActivity.zeusSuperSetTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048772, this, callback, i2)) == null) ? this.mProxyActivity.zeusSuperStartActionMode(callback, i2) : (ActionMode) invokeLI.objValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048774, this, intentArr, bundle) == null) {
            this.mProxyActivity.zeusSuperStartActivities(intentArr, bundle);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048776, this, intent, bundle) == null) {
            this.mProxyActivity.zeusSuperStartActivity(intent, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048778, this, intent, i2, bundle) == null) {
            this.mProxyActivity.zeusSuperStartActivityForResult(intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048780, this, activity, intent, i2, bundle) == null) {
            this.mProxyActivity.zeusSuperStartActivityFromChild(activity, intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048782, this, fragment, intent, i2, bundle) == null) {
            this.mProxyActivity.zeusSuperStartActivityFromFragment(fragment, intent, i2, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048784, this, intent, i2, bundle)) == null) ? this.mProxyActivity.zeusSuperStartActivityIfNeeded(intent, i2, bundle) : invokeLIL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048786, this, new Object[]{intentSender, intent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bundle}) == null) {
            this.mProxyActivity.zeusSuperStartIntentSender(intentSender, intent, i2, i3, i4, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048788, this, new Object[]{intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            this.mProxyActivity.zeusSuperStartIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048790, this, new Object[]{activity, intentSender, Integer.valueOf(i2), intent, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bundle}) == null) {
            this.mProxyActivity.zeusSuperStartIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048795, this, intent, bundle)) == null) ? this.mProxyActivity.zeusSuperStartNextMatchingActivity(intent, bundle) : invokeLL.booleanValue;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048655, this, bundle, persistableBundle) == null) {
            this.mProxyActivity.zeusSuperOnCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, view) == null) {
            this.mProxyActivity.zeusSuperSetContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048745, this, view, layoutParams) == null) {
            this.mProxyActivity.zeusSuperSetContentView(view, layoutParams);
        }
    }
}
