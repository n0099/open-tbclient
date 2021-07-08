package com.baidu.ugc.editvideo.faceunity.gles;

import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class FullFrameRect {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAngle;
    public float[] mModelViewMatrix;
    public float[] mMvpMtx;
    public Texture2dProgram mProgram;
    public final Drawable2d mRectDrawable;
    public final Drawable2d mRectLine;
    public float mScaleX;
    public float mScaleY;
    public float[] mScratchMatrix;

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture2dProgram};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.mRectLine = new Drawable2d(Drawable2d.Prefab.FULL_LINE);
        this.mMvpMtx = GlUtil.IDENTITY_MATRIX;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mScratchMatrix = new float[16];
        this.mModelViewMatrix = new float[16];
        this.mProgram = texture2dProgram;
    }

    private void recomputeMatrix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            float[] fArr = this.mModelViewMatrix;
            Matrix.setIdentityM(fArr, 0);
            float f2 = this.mAngle;
            if (f2 != 0.0f) {
                Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
            }
            Matrix.scaleM(fArr, 0, this.mScaleX, this.mScaleY, 1.0f);
        }
    }

    public void changeProgram(Texture2dProgram texture2dProgram) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, texture2dProgram) == null) {
            this.mProgram.release();
            this.mProgram = texture2dProgram;
        }
    }

    public int createTexture2DObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mProgram.createTexture2DObject() : invokeV.intValue;
    }

    public int createTextureObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mProgram.createTextureObject() : invokeV.intValue;
    }

    public void drawFrame(int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, fArr) == null) {
            drawFrame(i2, fArr, false);
        }
    }

    public float[] getModelViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            recomputeMatrix();
            return this.mModelViewMatrix;
        }
        return (float[]) invokeV.objValue;
    }

    public Texture2dProgram getProgram() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mProgram : (Texture2dProgram) invokeV.objValue;
    }

    public void release(boolean z) {
        Texture2dProgram texture2dProgram;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (texture2dProgram = this.mProgram) == null) {
            return;
        }
        if (z) {
            texture2dProgram.release();
        }
        this.mProgram = null;
    }

    public void setAlpha(float f2) {
        Texture2dProgram texture2dProgram;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || (texture2dProgram = this.mProgram) == null) {
            return;
        }
        texture2dProgram.setAlpha(f2);
    }

    public void setAngle(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            this.mAngle = f2;
        }
    }

    public void setDistance(float f2) {
        Texture2dProgram texture2dProgram;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f2) == null) || (texture2dProgram = this.mProgram) == null) {
            return;
        }
        texture2dProgram.setDistance(f2);
    }

    public void setDxDy(float f2, float f3) {
        Texture2dProgram texture2dProgram;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (texture2dProgram = this.mProgram) == null) {
            return;
        }
        texture2dProgram.setDxDy(f2, f3);
    }

    public void setHumanSegMaskParams(int i2, String str, float f2) {
        Texture2dProgram texture2dProgram;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), str, Float.valueOf(f2)}) == null) || (texture2dProgram = this.mProgram) == null) {
            return;
        }
        texture2dProgram.setHumanSegMaskParams(i2, str, f2);
    }

    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mScaleX = z ? this.mScaleX * (-1.0f) : this.mScaleX;
        }
    }

    public void setScale(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mRectDrawable.setScale(f2, f3);
        }
    }

    public void setScaleAndTranslate(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.mRectDrawable.setScaleAndTranslate(f2, f3, f4, f5);
        }
    }

    public void setShaderBgColor(String str) {
        Texture2dProgram texture2dProgram;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (texture2dProgram = this.mProgram) == null) {
            return;
        }
        texture2dProgram.setShaderBgColor(str);
    }

    public void setVertexPoint(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fArr) == null) {
            this.mMvpMtx = fArr;
        }
    }

    public void drawFrame(int i2, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), fArr, Boolean.valueOf(z)}) == null) || this.mProgram == null) {
            return;
        }
        float[] fArr2 = this.mMvpMtx;
        if (z) {
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr2, 0, getModelViewMatrix(), 0);
        } else if (this.mAngle != 0.0f) {
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr2, 0, getModelViewMatrix(), 0);
        } else {
            this.mScratchMatrix = fArr2;
        }
        this.mProgram.draw(this.mScratchMatrix, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i2, this.mRectDrawable.getTexCoordStride());
    }

    public void drawFrame(int i2, float[] fArr, int i3, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), fArr, Integer.valueOf(i3), fArr2}) == null) {
            drawFrame(i2, fArr, i3, fArr2, false);
        }
    }

    public void drawFrame(int i2, float[] fArr, int i3, float[] fArr2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), fArr, Integer.valueOf(i3), fArr2, Boolean.valueOf(z)}) == null) || this.mProgram == null) {
            return;
        }
        float[] fArr3 = GlUtil.IDENTITY_MATRIX;
        if (z) {
            this.mScaleX = -1.0f;
            this.mAngle = 180.0f;
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr3, 0, getModelViewMatrix(), 0);
        } else if (this.mAngle != 0.0f) {
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr3, 0, getModelViewMatrix(), 0);
        } else {
            this.mScratchMatrix = fArr3;
        }
        this.mProgram.draw(this.mScratchMatrix, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i2, this.mRectDrawable.getTexCoordStride(), i3, fArr2, this.mRectDrawable.getTexCoordArray2());
    }

    public void drawFrame(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fArr) == null) {
            this.mProgram.draw(fArr, this.mRectLine.getVertexArray());
        }
    }
}
